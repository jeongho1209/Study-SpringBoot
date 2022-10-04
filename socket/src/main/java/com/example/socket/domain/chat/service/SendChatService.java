package com.example.socket.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.socket.domain.chat.domain.Message;
import com.example.socket.domain.chat.domain.Room;
import com.example.socket.domain.chat.domain.repository.MessageRepository;
import com.example.socket.domain.chat.exception.RoomUserNotFoundException;
import com.example.socket.domain.chat.facade.RoomFacade;
import com.example.socket.domain.chat.facade.MemberFacade;
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

    private final RoomFacade roomFacade;
    private final UserFacade userFacade;
    private final MemberFacade memberFacade;
    private final MessageRepository messageRepository;

    @Transactional
    public void execute(SocketIOClient client, SocketIOServer server, SendChatRequest request) {

        Room room = roomFacade.getRoom(request.getRoomId());
        User user = userFacade.getCurrentUser(client);

        if (!memberFacade.checkRoomUserExist(room, user)) {
            throw RoomUserNotFoundException.EXCEPTION;
        }

        Message message = Message.builder()
                .message(request.getMessage())
                .room(room)
                .user(user)
                .build();

        messageRepository.save(message);

        server.getRoomOperations(room.getId().toString())
                .sendEvent(SocketProperty.MESSAGE_KEY, message);
    }

}
