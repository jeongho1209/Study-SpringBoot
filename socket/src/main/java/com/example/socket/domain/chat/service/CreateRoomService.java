package com.example.socket.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.socket.domain.chat.domain.Member;
import com.example.socket.domain.chat.domain.Room;
import com.example.socket.domain.chat.domain.repository.MemberRepository;
import com.example.socket.domain.chat.domain.repository.RoomRepository;
import com.example.socket.domain.chat.presentation.dto.request.CreateRoomRequest;
import com.example.socket.domain.user.domain.User;
import com.example.socket.domain.user.facade.UserFacade;
import com.example.socket.global.websocket.property.ClientProperty;
import com.example.socket.global.websocket.property.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateRoomService {

    private final UserFacade userFacade;
    private final RoomRepository roomRepository;
    private final MemberRepository memberRepository;
    private final SocketIOServer socketIOServer;

    @Transactional
    public void execute(SocketIOClient client, CreateRoomRequest request) {
        User user = userFacade.findUserByAccountId(client.get(ClientProperty.USER_KEY));

        Room room = roomRepository.save(Room.builder()
                .roomType(request.getRoomType())
                .name(request.getRoomName())
                .build());

        memberRepository.save(Member.builder()
                .room(room)
                .user(user)
                .build());

        String socketRoomId = room.getId().toString();
        client.joinRoom(socketRoomId);

        socketIOServer.getRoomOperations(socketRoomId)
                .sendEvent(SocketProperty.ROOM);
    }

}
