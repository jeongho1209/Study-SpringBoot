package com.example.socket.domain.chat.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageDto {

    private final String message;
    private final Integer roomId;

}
