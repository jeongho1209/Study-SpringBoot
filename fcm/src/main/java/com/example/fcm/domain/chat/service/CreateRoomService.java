package com.example.fcm.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.fcm.domain.chat.domain.room.Room;
import com.example.fcm.domain.chat.domain.room.RoomRepository;
import com.example.fcm.domain.chat.domain.roomuser.RoomUser;
import com.example.fcm.domain.chat.domain.roomuser.RoomUserRepository;
import com.example.fcm.domain.chat.presentation.dto.request.CreateRoomRequest;
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
public class CreateRoomService {

    private final RoomRepository roomRepository;
    private final RoomUserRepository roomUserRepository;
    private final UserFacade userFacade;
    private final SocketIOServer socketIOServer;

    @Transactional
    public void execute(SocketIOClient socketIOClient, CreateRoomRequest request) {
        User user = userFacade.findUserByEmail(socketIOClient.get(ClientProperty.USER_KEY));

        Room room = roomRepository.save(Room.builder()
                .roomName(request.getRoomName())
                .build());

        roomUserRepository.save(RoomUser.builder()
                .user(user)
                .room(room)
                .build());

        String socketRoomId = room.getId().toString();
        socketIOClient.joinRoom(socketRoomId);

        RoomNotificationResponse response = new RoomNotificationResponse(socketRoomId, user.getName() + "입장!");

        socketIOServer.getRoomOperations(socketRoomId)
                .sendEvent(SocketProperty.ROOM, response);
    }

}
