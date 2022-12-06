package com.example.fcm.domain.user.service;

import com.example.fcm.domain.auth.presentation.dto.response.TokenResponse;
import com.example.fcm.domain.user.domain.User;
import com.example.fcm.domain.user.domain.UserRepository;
import com.example.fcm.domain.user.exception.PasswordMisMatchException;
import com.example.fcm.domain.user.presentation.dto.request.UserSignInRequest;
import com.example.fcm.global.exception.UserNotFoundException;
import com.example.fcm.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(UserSignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(request.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getEmail());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

}
