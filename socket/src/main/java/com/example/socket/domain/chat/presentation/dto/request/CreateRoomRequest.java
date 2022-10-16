package com.example.socket.domain.chat.presentation.dto.request;

import com.example.socket.domain.chat.domain.enums.RoomType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateRoomRequest {

    private String roomName;
    private RoomType roomType;

}
