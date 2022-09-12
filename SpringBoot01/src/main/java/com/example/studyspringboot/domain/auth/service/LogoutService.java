package com.example.studyspringboot.domain.auth.service;

import com.example.studyspringboot.domain.auth.domain.RefreshToken;
import com.example.studyspringboot.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.studyspringboot.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LogoutService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute() {
        User user = userFacade.getCurrentUser();

        RefreshToken refreshToken = refreshTokenRepository.findById(user.getAccountId())
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        refreshTokenRepository.delete(refreshToken);
    }

}
