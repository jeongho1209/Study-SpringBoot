package com.example.fcm.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.fcm.domain.chat.domain.message.Message;
import com.example.fcm.domain.chat.domain.message.MessageRepository;
import com.example.fcm.domain.chat.domain.room.Room;
import com.example.fcm.domain.chat.facade.RoomFacade;
import com.example.fcm.domain.chat.presentation.dto.request.SendChatRequest;
import com.example.fcm.domain.chat.presentation.dto.response.MessageResponse;
import com.example.fcm.domain.user.domain.User;
import com.example.fcm.domain.user.facade.UserFacade;
import com.example.fcm.global.websocket.property.ClientProperty;
import com.example.fcm.global.websocket.property.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SendChatService {

    private final UserFacade userFacade;
    private final RoomFacade roomFacade;
    private final MessageRepository messageRepository;
    private final SocketIOServer socketIOServer;

    @Transactional
    public void execute(SocketIOClient socketIOClient, SendChatRequest request) {
        User user = userFacade.findUserByEmail(socketIOClient.get(ClientProperty.USER_KEY));
        Room room = roomFacade.getRoom(request.getRoomId());

        Message message = messageRepository.save(Message.builder()
                .message(request.getMessage())
                .user(user)
                .room(room)
                .build());

        socketIOServer
                .getRoomOperations(room.getId().toString())
                .getClients()
                .forEach(client -> {
                            client.sendEvent(SocketProperty.MESSAGE_KEY, MessageResponse.of(message));
                        }
                );
    }

}