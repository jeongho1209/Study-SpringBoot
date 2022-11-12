package com.example.fcm.domain.chat.presentation.dto.response;

import com.example.fcm.domain.chat.domain.room.Room;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoomElement {

    private final Long roomId;
    private final String roomName;
    private final int roomUserCount;

    public static RoomElement of(Room room) {
        return RoomElement.builder()
                .roomId(room.getId())
                .roomUserCount(room.getRoomUsers().size())
                .roomName(room.getRoomName())
                .build();
    }

}
