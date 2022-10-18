package com.example.socket.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.socket.domain.chat.domain.Room;
import com.example.socket.domain.chat.domain.repository.MemberRepository;
import com.example.socket.domain.chat.exception.MemberNotFoundException;
import com.example.socket.domain.chat.facade.RoomFacade;
import com.example.socket.domain.chat.presentation.dto.MessageDto;
import com.example.socket.domain.chat.presentation.dto.request.SendChatRequest;
import com.example.socket.domain.user.domain.User;
import com.example.socket.domain.user.facade.UserFacade;
import com.example.socket.global.websocket.property.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SendChatService {

    private final MemberRepository memberRepository;
    private final UserFacade userFacade;
    private final RoomFacade roomFacade;

    @Transactional
    public void execute(SocketIOClient client, SocketIOServer socketIOServer, SendChatRequest request) {
        Room room = roomFacade.getRoom(request.getRoomId());
        User user = userFacade.findUserByClient(client);

        if (!memberRepository.existsByRoomAndUser(room, user)) {
            throw MemberNotFoundException.EXCEPTION;
        }

        MessageDto messageDto = MessageDto.builder()
                .userId(user.getId())
                .message(request.getMessage())
                .build();

        socketIOServer.getRoomOperations(room.getId().toString())
                .sendEvent(SocketProperty.MESSAGE_KEY, messageDto);
    }

}