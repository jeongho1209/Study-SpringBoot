package com.example.socket.domain.chat.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SendChatRequest {

    private Integer room;

    private String message;

}