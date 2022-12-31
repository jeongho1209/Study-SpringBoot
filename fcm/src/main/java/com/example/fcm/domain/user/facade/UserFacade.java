package com.example.fcm.domain.user.facade;

import com.example.fcm.domain.user.domain.User;
import com.example.fcm.domain.user.domain.repository.UserRepository;
import com.example.fcm.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getEmail(email);
    }

    public User findUserByEmail(String accountId) {
        return getEmail(accountId);
    }

    public User getEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
