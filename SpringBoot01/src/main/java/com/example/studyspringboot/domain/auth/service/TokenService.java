package com.example.studyspringboot.domain.auth.service;

import com.example.studyspringboot.domain.auth.exception.PasswordMisMatchException;
import com.example.studyspringboot.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.studyspringboot.domain.auth.presentation.dto.response.TokenResponse;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.domain.repository.UserRepository;
import com.example.studyspringboot.domain.user.exception.UserNotFoundException;
import com.example.studyspringboot.global.enums.Role;
import com.example.studyspringboot.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse signIn(UserSignInRequest request, Role role){
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(request.getAccountId(), role)
    }
}
