package com.example.oauth.domain.auth.presentation;

import com.example.oauth.domain.auth.presentation.dto.response.TokenResponse;
import com.example.oauth.domain.auth.service.ReissueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final ReissueService reissueService;

    @PatchMapping("/token")
    public TokenResponse reissue(@RequestHeader("Refresh-Token") String refreshToken) {
        return reissueService.reissue(refreshToken);
    }

}
