package com.example.fcm.domain.user.service;

import com.example.fcm.domain.user.domain.User;
import com.example.fcm.domain.user.domain.UserRepository;
import com.example.fcm.domain.user.exception.UserExistException;
import com.example.fcm.domain.user.presentation.dto.UserSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(UserSignUpRequest request) {
        if (userRepository.findByAccountId(request.getAccountId()).isPresent()) {
            throw UserExistException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .build());
    }

}
