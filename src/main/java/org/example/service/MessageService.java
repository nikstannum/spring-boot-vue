package org.example.service;

import org.example.service.dto.MessageDto;

import java.util.List;

public interface MessageService {

    MessageDto create(MessageDto messageDto);

    List<MessageDto> getAll();

    MessageDto getById(Long id);

    MessageDto update(Long id, MessageDto dto);

    void deleteById(Long id);

}
