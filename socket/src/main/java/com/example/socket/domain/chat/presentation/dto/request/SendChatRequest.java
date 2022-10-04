package com.example.socket.domain.chat.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SendChatRequest {

    private Integer roomId;
    private String message;

}
