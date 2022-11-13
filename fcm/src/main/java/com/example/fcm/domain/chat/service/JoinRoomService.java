package com.example.fcm.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.fcm.domain.chat.domain.room.Room;
import com.example.fcm.domain.chat.domain.roomuser.RoomUser;
import com.example.fcm.domain.chat.exception.RoomUserExistException;
import com.example.fcm.domain.chat.facade.RoomFacade;
import com.example.fcm.domain.chat.facade.RoomUserFacade;
import com.example.fcm.domain.chat.presentation.dto.request.JoinRoomRequest;
import com.example.fcm.domain.chat.presentation.dto.response.RoomNotificationResponse;
import com.example.fcm.domain.user.domain.User;
import com.example.fcm.domain.user.facade.UserFacade;
import com.example.fcm.global.websocket.property.ClientProperty;
import com.example.fcm.global.websocket.property.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class JoinRoomService {

    private final UserFacade userFacade;
    private final RoomFacade roomFacade;
    private final RoomUserFacade roomUserFacade;
    private final SocketIOServer socketIOServer;

    @Transactional
    public void execute(SocketIOClient socketIOClient, JoinRoomRequest request) {
        User user = userFacade.findUserByAccountId(socketIOClient.get(ClientProperty.USER_KEY));
        Room room = roomFacade.getRoom(request.getRoomId());

        if (roomUserFacade.existUser(user, room)) {
            throw RoomUserExistException.EXCEPTION;
        }

        room.addRoomUser(RoomUser.builder()
                .room(room)
                .user(user)
                .build());

        String roomId = room.getId().toString();
        socketIOClient.joinRoom(roomId);

        RoomNotificationResponse response = new RoomNotificationResponse(roomId, user.getName() + "입장!");

        socketIOServer.getRoomOperations(roomId)
                .sendEvent(SocketProperty.JOIN, response);
    }

}
