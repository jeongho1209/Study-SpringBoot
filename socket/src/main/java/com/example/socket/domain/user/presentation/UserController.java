package com.example.socket.domain.user.presentation;

import com.example.socket.domain.user.presentation.dto.request.SignInRequest;
import com.example.socket.domain.user.presentation.dto.request.SignUpRequest;
import com.example.socket.domain.user.presentation.dto.response.TokenResponse;
import com.example.socket.domain.user.service.SignInService;
import com.example.socket.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final SignUpService signUpService;
    private final SignInService signInService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public TokenResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return signUpService.execute(request);
    }

    @PostMapping("/login")
    public TokenResponse logIn(@RequestBody @Valid SignInRequest request) {
        return signInService.execute(request);
    }

}
