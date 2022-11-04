package com.example.fcm.domain.auth.service;

import com.example.fcm.domain.auth.domain.RefreshToken;
import com.example.fcm.domain.auth.domain.RefreshTokenRepository;
import com.example.fcm.domain.auth.presentation.dto.response.TokenResponse;
import com.example.fcm.domain.user.domain.User;
import com.example.fcm.domain.user.domain.UserRepository;
import com.example.fcm.domain.user.exception.UserExistException;
import com.example.fcm.global.property.AuthProperty;
import com.example.fcm.global.property.JwtProperty;
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
    private final JwtProperty jwtProperty;
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

        String accountId = response.getAccountId();
        String name = response.getName();

        String refreshToken = jwtTokenProvider.generateRefreshToken(accountId);

        refreshTokenRepository.save(RefreshToken.builder()
                .accountId(accountId)
                .token(refreshToken)
                .ttl(jwtProperty.getRefreshExp())
                .build());

        createUser(accountId, name);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void createUser(String accountId, String name) {
        if (userRepository.findByAccountId(accountId).isPresent()) {
            throw UserExistException.EXCEPTION;
        }
        userRepository.save(User.builder()
                .accountId(accountId)
                .name(name)
                .build());
    }

}
