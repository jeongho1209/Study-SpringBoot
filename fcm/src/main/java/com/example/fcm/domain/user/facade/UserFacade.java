package com.example.fcm.domain.user.facade;

import com.example.fcm.domain.user.domain.User;
import com.example.fcm.domain.user.domain.UserRepository;
import com.example.fcm.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getAccountId(accountId);
    }

    public User findUserByAccountId(String accountId) {
        return getAccountId(accountId);
    }

    public User getAccountId(String accountId) {
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
