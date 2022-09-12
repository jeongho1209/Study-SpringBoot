package com.example.studyspringboot.domain.auth.presentation;

import com.example.studyspringboot.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.studyspringboot.domain.auth.presentation.dto.response.TokenResponse;
import com.example.studyspringboot.domain.auth.service.ReissueService;
import com.example.studyspringboot.domain.auth.service.TokenService;
import com.example.studyspringboot.global.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final TokenService tokenService;
    private final ReissueService reissueService;

    @PostMapping("/token")
    public TokenResponse signIn(@RequestBody @Valid UserSignInRequest request, Role role) {
        return tokenService.signIn(request, role);
    }

    @PatchMapping("/token")
    public TokenResponse reissue(String refreshToken, Role role) {
        return reissueService.reissue(refreshToken, role);
    }

}
