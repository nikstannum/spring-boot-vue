package org.example.service.mapper.impl;

import org.example.data.entity.Message;
import org.example.service.dto.MessageDto;
import org.example.service.mapper.MessageMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message convert(MessageDto dto) {
        Message message = new Message();
        message.setId(dto.getId());
        message.setMessage(dto.getMessage());
        return message;
    }

    @Override
    public MessageDto convert(Message message) {
        MessageDto dto = new MessageDto();
        dto.setId(message.getId());
        dto.setMessage(message.getMessage());
        return dto;
    }

}
