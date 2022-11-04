package com.example.fcm.domain.auth.presentation;

import com.example.fcm.domain.auth.presentation.dto.response.TokenResponse;
import com.example.fcm.domain.auth.service.GoogleAuthService;
import com.example.fcm.domain.auth.service.QueryGoogleAuthLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class GoogleAuthController {

    private final GoogleAuthService googleAuthService;
    private final QueryGoogleAuthLinkService queryGoogleAuthLinkService;

    @GetMapping("/receive-code")
    public TokenResponse googleAuthLogIn(@RequestParam("code") String code) {
        return googleAuthService.execute(code);
    }

    @GetMapping("/google/auth")
    public String queryGoogleAuthLink() {
        return queryGoogleAuthLinkService.execute();
    }

}
