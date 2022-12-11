package com.example.fcm.domain.chat.presentation;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.example.fcm.domain.chat.presentation.dto.request.CreateRoomRequest;
import com.example.fcm.domain.chat.presentation.dto.request.JoinRoomRequest;
import com.example.fcm.domain.chat.presentation.dto.request.LeaveRoomRequest;
import com.example.fcm.domain.chat.presentation.dto.request.SendChatRequest;
import com.example.fcm.domain.chat.service.CreateRoomService;
import com.example.fcm.domain.chat.service.JoinRoomService;
import com.example.fcm.domain.chat.service.LeaveRoomService;
import com.example.fcm.domain.chat.service.SendChatService;
import com.example.fcm.global.websocket.property.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatSocketController {

    private final CreateRoomService createRoomService;
    private final JoinRoomService joinRoomService;
    private final LeaveRoomService leaveRoomService;
    private final SendChatService sendChatService;

    @OnEvent(SocketProperty.ROOM)
    public void createRoom(SocketIOClient socketIOClient, @RequestBody CreateRoomRequest request) {
        createRoomService.execute(socketIOClient, request);
    }

    @OnEvent(SocketProperty.JOIN)
    public void joinRoom(SocketIOClient socketIOClient, @RequestBody JoinRoomRequest request) {
        joinRoomService.execute(socketIOClient, request);
    }

    @OnEvent(SocketProperty.LEAVE)
    public void leaveRoom(SocketIOClient socketIOClient, @RequestBody LeaveRoomRequest request) {
        leaveRoomService.execute(socketIOClient, request);
    }

    @OnEvent(SocketProperty.MESSAGE_KEY)
    public void sendMessage(SocketIOClient socketIOClient, @RequestBody SendChatRequest request) {
        sendChatService.execute(socketIOClient, request);
    }

}
