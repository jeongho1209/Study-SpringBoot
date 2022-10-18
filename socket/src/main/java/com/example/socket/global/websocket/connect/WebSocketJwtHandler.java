package com.example.socket.global.websocket.connect;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.example.socket.global.security.jwt.JwtTokenProvider;
import com.example.socket.global.websocket.property.ClientProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketJwtHandler {

    private final JwtTokenProvider jwtTokenProvider;

    public static final ConcurrentMap<String, SocketIOClient> socketIOClientMap =
            new ConcurrentHashMap<>();

    @OnConnect
    public void onConnect(SocketIOClient client) {
        String token = client.getHandshakeData().getHttpHeaders().get("Authorization");
        Authentication authentication = jwtTokenProvider.authentication(token);
        String accountId = authentication.getName();
        client.set(ClientProperty.USER_KEY, accountId);
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        socketIOClientMap.remove(client.get(ClientProperty.USER_KEY).toString());
    }

}
