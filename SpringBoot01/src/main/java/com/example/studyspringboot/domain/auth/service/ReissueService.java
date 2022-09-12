package com.example.studyspringboot.domain.auth.service;

import com.example.studyspringboot.domain.auth.domain.RefreshToken;
import com.example.studyspringboot.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.studyspringboot.domain.auth.exception.InvalidRefreshTokenException;
import com.example.studyspringboot.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.studyspringboot.domain.auth.presentation.dto.response.TokenResponse;
import com.example.studyspringboot.global.enums.Role;
import com.example.studyspringboot.global.security.jwt.JwtProperty;
import com.example.studyspringboot.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReissueService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperty jwtProperty;

    @Transactional
    public TokenResponse reissue(String refreshToken, Role role) {
        String parseToken = jwtTokenProvider.parseToken(refreshToken);
        if (parseToken == null) {
            throw InvalidRefreshTokenException.EXCEPTION;
        }

        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(jwtTokenProvider.parseToken(refreshToken))
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(redisRefreshToken.getAccountId(), role);
        redisRefreshToken.updateToken(newRefreshToken, jwtProperty.getRefreshExp());

        String newAccessToken = jwtTokenProvider.generateAccessToken(redisRefreshToken.getAccountId(), role);

        return TokenResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .build();
    }

}
