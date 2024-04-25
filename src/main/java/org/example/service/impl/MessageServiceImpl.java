package org.example.service.impl;

import org.example.data.entity.Message;
import org.example.data.repository.MessageRepository;
import org.example.service.MessageService;
import org.example.service.dto.MessageDto;
import org.example.service.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;

    private final MessageMapper mapper;

    public MessageServiceImpl(MessageRepository repository, MessageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MessageDto create(MessageDto messageDto) {
        Message message = mapper.convert(messageDto);
        Message created = repository.create(message);
        return mapper.convert(created);
    }

    @Override
    public List<MessageDto> getAll() {
        return repository.getAll().stream()
                .map(mapper::convert)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDto getById(Long id) {
        Message message = repository.getById(id)
                .orElseThrow(() -> new RuntimeException("Not found message with id = " + id));
        return mapper.convert(message);
    }

    @Override
    public MessageDto update(Long id, MessageDto dto) {
        Message message = mapper.convert(dto);
        repository.update(id, message);
        return mapper.convert(message);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
