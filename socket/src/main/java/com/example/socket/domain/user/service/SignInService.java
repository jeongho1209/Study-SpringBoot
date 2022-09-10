package com.example.socket.domain.user.service;

import com.example.socket.domain.user.domain.User;
import com.example.socket.domain.user.domain.repository.UserRepository;
import com.example.socket.domain.user.exception.PasswordMisMatchException;
import com.example.socket.domain.user.exception.UserNotFoundException;
import com.example.socket.domain.user.presentation.dto.request.SignInRequest;
import com.example.socket.domain.user.presentation.dto.response.TokenResponse;
import com.example.socket.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(SignInRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(request.getAccountId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getAccountId());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

}
