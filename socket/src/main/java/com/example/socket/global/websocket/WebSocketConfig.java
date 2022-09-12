package com.example.socket.global.websocket;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import com.example.socket.global.websocket.exception.SocketExceptionListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSocketConfig {

    @Value("${socket.port}")
    private Integer port;

    @Bean
    public SocketIOServer socketIOServer() {

        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);

        com.corundumstudio.socketio.Configuration configuration = new com.corundumstudio.socketio.Configuration();
        configuration.setPort(port);
        configuration.setOrigin("*");
        configuration.setSocketConfig(socketConfig);
        configuration.setExceptionListener(new SocketExceptionListener());

        return new SocketIOServer(configuration);
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketIOServer) {
        return new SpringAnnotationScanner(socketIOServer);
    }

}
