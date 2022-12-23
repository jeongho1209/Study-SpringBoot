package com.example.fcm.domain.chat.service;

import com.example.fcm.domain.chat.domain.message.MessageRepository;
import com.example.fcm.domain.chat.domain.room.Room;
import com.example.fcm.domain.chat.facade.RoomFacade;
import com.example.fcm.domain.chat.facade.RoomUserFacade;
import com.example.fcm.domain.chat.presentation.dto.request.QueryRoomRequest;
import com.example.fcm.domain.chat.presentation.dto.response.MessageResponse;
import com.example.fcm.domain.chat.presentation.dto.response.QueryMessageListResponse;
import com.example.fcm.domain.user.domain.User;
import com.example.fcm.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryMessageListService {

    private final MessageRepository messageRepository;
    private final UserFacade userFacade;
    private final RoomFacade roomFacade;
    private final RoomUserFacade roomUserFacade;

    @Transactional
    public QueryMessageListResponse execute(QueryRoomRequest request) {
        User user = userFacade.getCurrentUser();
        Room room = roomFacade.getRoom(request.getRoomId());
        roomUserFacade.getRoomUser(user, room);

        return new QueryMessageListResponse(
                messageRepository.queryMessagesByRoom(request.getRoomId())
                        .stream()
                        .map(MessageResponse::of)
                        .collect(Collectors.toList())
        );
    }

}
