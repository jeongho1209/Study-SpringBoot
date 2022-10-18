package com.example.socket.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.socket.domain.chat.domain.Member;
import com.example.socket.domain.chat.domain.Room;
import com.example.socket.domain.chat.facade.RoomFacade;
import com.example.socket.domain.chat.presentation.dto.request.JoinRoomRequest;
import com.example.socket.domain.user.domain.User;
import com.example.socket.domain.user.facade.UserFacade;
import com.example.socket.global.websocket.property.ClientProperty;
import com.example.socket.global.websocket.property.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class JoinRoomService {

    private final RoomFacade roomFacade;
    private final UserFacade userFacade;
    private final SocketIOServer socketIOServer;

    @Transactional
    public void execute(SocketIOClient client, JoinRoomRequest request) {
        User user = userFacade.findUserByAccountId(client.get(ClientProperty.USER_KEY));
        Room room = roomFacade.getRoom(request.getRoomId());

        room.addMember(Member.builder()
                .room(room)
                .user(user)
                .build());

        String roomId = room.getId().toString();
        client.joinRoom(roomId);

        socketIOServer.getRoomOperations(roomId)
                .sendEvent(SocketProperty.ROOM);
    }

}
