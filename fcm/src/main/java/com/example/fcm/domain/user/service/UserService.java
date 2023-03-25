package com.example.fcm.domain.user.service;

import com.example.fcm.domain.auth.presentation.dto.response.TokenResponse;
import com.example.fcm.domain.user.domain.User;
import com.example.fcm.domain.user.domain.repository.UserRepository;
import com.example.fcm.domain.user.exception.PasswordMisMatchException;
import com.example.fcm.domain.user.exception.UserExistException;
import com.example.fcm.domain.user.facade.UserFacade;
import com.example.fcm.domain.user.presentation.dto.request.UserSignInRequest;
import com.example.fcm.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.fcm.domain.user.presentation.dto.response.QueryUserElement;
import com.example.fcm.domain.user.presentation.dto.response.QueryUserListResponse;
import com.example.fcm.global.exception.UserNotFoundException;
import com.example.fcm.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserFacade userFacade;

    @Transactional
    public TokenResponse execute(UserSignUpRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw UserExistException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .build());

        String accessToken = jwtTokenProvider.generateAccessToken(request.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getEmail());

        return builderTokenResponse(accessToken, refreshToken);
    }

    @Transactional
    public TokenResponse execute(UserSignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(request.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getEmail());

        return builderTokenResponse(accessToken, refreshToken);
    }

    @Transactional(readOnly = true)
    public QueryUserListResponse execute() {
        return new QueryUserListResponse(
                userRepository.queryUserPaging()
                        .stream()
                        .map(QueryUserElement::of)
                        .collect(Collectors.toList())
        );
    }

    @Transactional
    public void userWithdrawal() {
        userRepository.delete(userFacade.getCurrentUser());
    }

    private TokenResponse builderTokenResponse(String accessToken, String refreshToken) {
        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
