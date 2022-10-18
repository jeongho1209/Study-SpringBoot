package com.example.socket.domain.chat.presentation;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.example.socket.domain.chat.presentation.dto.request.CreateRoomRequest;
import com.example.socket.domain.chat.presentation.dto.request.JoinRoomRequest;
import com.example.socket.domain.chat.presentation.dto.request.SendChatRequest;
import com.example.socket.domain.chat.service.CreateRoomService;
import com.example.socket.domain.chat.service.JoinRoomService;
import com.example.socket.domain.chat.service.SendChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatSocketController {

    private final SendChatService sendChatService;
    private final CreateRoomService createRoomService;
    private final JoinRoomService joinRoomService;

    @OnEvent("chat")
    public void sendChat(SocketIOClient client, SocketIOServer server, @RequestBody SendChatRequest request) {
        sendChatService.execute(client, server, request);
    }

    @OnEvent("create")
    public void createRoom(SocketIOClient client, @RequestBody CreateRoomRequest request) {
        createRoomService.execute(client, request);
    }

    @OnEvent("join")
    public void joinRoom(SocketIOClient client, @RequestBody JoinRoomRequest request) {
        joinRoomService.execute(client, request);
    }

}
