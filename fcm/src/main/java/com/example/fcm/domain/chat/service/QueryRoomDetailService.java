package com.example.fcm.domain.chat.service;

import com.example.fcm.domain.chat.domain.room.Room;
import com.example.fcm.domain.chat.facade.RoomFacade;
import com.example.fcm.domain.chat.presentation.dto.response.QueryRoomDetailResponse;
import com.example.fcm.domain.user.domain.User;
import com.example.fcm.domain.user.facade.UserFacade;
import com.example.fcm.domain.user.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryRoomDetailService {

    private final UserFacade userFacade;
    private final RoomFacade roomFacade;

    @Transactional(readOnly = true)
    public QueryRoomDetailResponse execute(Long roomId) {
        User user = userFacade.getCurrentUser();
        Room room = roomFacade.getRoom(roomId);

        return QueryRoomDetailResponse.builder()
                .roomId(roomId)
                .roomName(room.getRoomName())
                .roomUserCount(room.getRoomUsers().size())
                .userResponse(UserResponse.builder()
                        .userId(user.getId())
                        .userName(user.getName())
                        .build())
                .build();
    }

}
