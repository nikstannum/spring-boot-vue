package org.example.data.repository.impl;

import jakarta.annotation.PostConstruct;
import org.example.data.entity.Message;
import org.example.data.repository.MessageRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MessageInMemoryRepository implements MessageRepository {

    private Long counter = 0L;

    private Map<Long, Message> memory = new HashMap<>();

    @Override
    public List<Message> getAll() {
        return new ArrayList<>(memory.values());
    }

    @Override
    public Optional<Message> getById(Long id) {
        return Optional.ofNullable(memory.get(id));
    }

    @Override
    public Message create(Message message) {
        return save(message);
    }

    @Override
    public void update(Long id, Message message) {
        message.setId(id);
        updateInMemory(message);
    }

    @Override
    public void deleteById(Long id) {
        memory.remove(id);
    }

    private void updateInMemory(Message message) {
        Message existing = memory.get(message.getId());
        if (existing == null) {
            throw new RuntimeException("Not found message with id = " + message.getId());
        }
        existing.setMessage(message.getMessage());
        memory.put(message.getId(), existing);
    }

    private Message save(Message message) {
        Long id = counter + 1L;
        message.setId(id);
        memory.put(id, message);
        return message;
    }

    @PostConstruct
    private void initMemory() {
        Message message1 = new Message();
        message1.setId(1L);
        message1.setMessage("message 1");

        Message message2 = new Message();
        message2.setId(2L);
        message2.setMessage("message 2");

        memory.put(1L, message1);
        memory.put(2L, message2);

        this.counter = 2L;
    }

}
