package com.example.socket.domain.user.presentation;

import com.example.socket.domain.auth.presentation.dto.response.TokenResponse;
import com.example.socket.domain.user.presentation.dto.request.SignUpRequest;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public TokenResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return signUpService.execute(request);
    }

}
