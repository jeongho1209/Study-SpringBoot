package com.example.fcm.domain.auth.service;

import com.example.fcm.global.property.AuthProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryGoogleAuthLinkService {

    private static final String URL = "%s?client_id=%s&redirect_uri=%s&response_type=code"
            + "&scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile";

    private final AuthProperty authProperty;

    public String execute() {
        return String.format(URL,
                authProperty.getBaseUrl(),
                authProperty.getClientId(),
                authProperty.getRedirectUrl());
    }
}
