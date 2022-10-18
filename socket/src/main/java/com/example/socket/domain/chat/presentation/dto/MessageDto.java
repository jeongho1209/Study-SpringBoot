package com.example.socket.domain.chat.presentation.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MessageDto {

    private Integer userId;
    private String message;

}