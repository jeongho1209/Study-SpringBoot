package com.example.fcm.domain.chat.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryRoomListResponse {

    private List<RoomElement> roomList;

}
