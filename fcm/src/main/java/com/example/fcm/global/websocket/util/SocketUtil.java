package com.example.fcm.global.websocket.util;

import com.corundumstudio.socketio.SocketIOClient;
import com.example.fcm.global.websocket.property.ClientProperty;

public class SocketUtil {

    public static String getUser(SocketIOClient socketIOClient) {
        return socketIOClient.get(ClientProperty.USER_KEY);
    }

}
