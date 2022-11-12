package com.example.fcm.domain.chat.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoomNotificationResponse {

    private String roomId;
    private String notification;

}
