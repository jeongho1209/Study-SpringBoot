package com.example.oauth.domain.user.service;

import com.example.oauth.domain.auth.presentation.dto.response.TokenResponse;
import com.example.oauth.domain.user.domain.User;
import com.example.oauth.domain.user.domain.repository.UserRepository;
import com.example.oauth.domain.user.exception.UserNotFoundException;
import com.example.oauth.domain.user.presentation.dto.request.UserSignInRequest;
import com.example.oauth.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.oauth.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void signUp(UserSignUpRequest request) {
        userRepository.save(User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .build());
    }

    @Transactional
    public TokenResponse logIn(UserSignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        String accessToken = jwtTokenProvider.generateAccessToken(user.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getEmail());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

}
