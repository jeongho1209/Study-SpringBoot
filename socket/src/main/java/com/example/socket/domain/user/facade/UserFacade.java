package com.example.socket.domain.user.facade;

import com.corundumstudio.socketio.SocketIOClient;
import com.example.socket.domain.user.domain.User;
import com.example.socket.domain.user.domain.repository.UserRepository;
import com.example.socket.domain.user.exception.UserNotFoundException;
import com.example.socket.global.websocket.property.ClientProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User findUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User findUserByClient(SocketIOClient client) {
        return userRepository.findById(client.get(ClientProperty.USER_KEY))
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}
