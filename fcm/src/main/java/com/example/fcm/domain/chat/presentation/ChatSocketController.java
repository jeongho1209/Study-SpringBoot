package com.example.fcm.domain.chat.presentation;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.example.fcm.domain.chat.presentation.dto.request.CreateRoomRequest;
import com.example.fcm.domain.chat.service.CreateRoomService;
import com.example.fcm.global.websocket.property.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatSocketController {

    private final CreateRoomService createRoomService;

    @OnEvent(SocketProperty.ROOM)
    public void createRoom(SocketIOClient socketIOClient, @RequestBody CreateRoomRequest request) {
        createRoomService.execute(socketIOClient, request);
    }

}
