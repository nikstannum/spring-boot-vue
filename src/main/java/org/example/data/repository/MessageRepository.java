package org.example.data.repository;

import org.example.data.entity.Message;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {

    List<Message> getAll();

    Optional<Message> getById(Long id);

    Message create(Message message);

    void update(Long id, Message message);

    void deleteById(Long id);

}
