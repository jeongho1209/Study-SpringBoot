package com.example.fcm.domain.chat.presentation.dto.response;

import com.example.fcm.domain.chat.domain.message.Message;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MessageResponse {

    @JsonProperty("room_id")
    private Long roomId;

    private String message;
    private String name;

    public static MessageResponse of(Message message) {

        return MessageResponse.builder()
                .roomId(message.getRoomId())
                .name(message.getUserName())
                .message(message.getMessage())
                .build();
    }

}
