package com.example.fcm.domain.auth.service;

import com.example.fcm.domain.auth.domain.RefreshToken;
import com.example.fcm.domain.auth.domain.RefreshTokenRepository;
import com.example.fcm.domain.auth.presentation.dto.response.TokenResponse;
import com.example.fcm.domain.user.domain.User;
import com.example.fcm.domain.user.domain.repository.UserRepository;
import com.example.fcm.domain.user.exception.UserExistException;
import com.example.fcm.global.property.AuthProperty;
import com.example.fcm.global.property.JwtProperties;
import com.example.fcm.global.security.jwt.JwtTokenProvider;
import com.example.fcm.infrastructure.feign.client.GoogleAuth;
import com.example.fcm.infrastructure.feign.client.GoogleInfo;
import com.example.fcm.infrastructure.feign.dto.request.GoogleCodeRequest;
import com.example.fcm.infrastructure.feign.dto.response.GoogleInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Service
public class GoogleAuthService {

    private final GoogleAuth googleAuth;
    private final GoogleInfo googleInfo;
    private final AuthProperty authProperty;
    private final JwtProperties jwtProperty;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(String code) {
        String accessToken = googleAuth.googleAuth(
                GoogleCodeRequest.builder()
                        .code(URLDecoder.decode(code, StandardCharsets.UTF_8))
                        .clientId(authProperty.getClientId())
                        .clientSecret(authProperty.getClientSecret())
                        .redirectUri(authProperty.getRedirectUrl())
                        .build()
        ).getAccessToken();

        GoogleInfoResponse response = googleInfo.googleInfo(accessToken);

        String email = response.getEmail();
        String name = response.getName();

        String refreshToken = jwtTokenProvider.generateRefreshToken(email);

        refreshTokenRepository.save(RefreshToken.builder()
                .email(email)
                .token(refreshToken)
                .ttl(jwtProperty.getRefreshExp())
                .build());

        createUser(email, name);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void createUser(String email, String name) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw UserExistException.EXCEPTION;
        }
        System.out.println("유저 객체 생성");
        userRepository.save(User.builder()
                .email(email)
                .name(name)
                .build());
    }

}
