package com.example.socket.domain.user.presentation;

import com.example.socket.domain.auth.presentation.dto.response.TokenResponse;
import com.example.socket.domain.user.presentation.dto.request.SignUpRequest;
import com.example.socket.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final SignUpService signUpService;

    @PostMapping("/signup")
    public TokenResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return signUpService.execute(request);
    }

}
