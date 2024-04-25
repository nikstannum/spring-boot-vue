package org.example.service.mapper;

import org.example.data.entity.Message;
import org.example.service.dto.MessageDto;

public interface MessageMapper {

    Message convert(MessageDto dto);

    MessageDto convert(Message message);

}
