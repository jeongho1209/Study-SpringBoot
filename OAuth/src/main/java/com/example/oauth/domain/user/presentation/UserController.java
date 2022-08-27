package com.example.oauth.domain.user.presentation;

import com.example.oauth.domain.auth.presentation.dto.response.TokenResponse;
import com.example.oauth.domain.user.presentation.dto.request.UserSignInRequest;
import com.example.oauth.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.oauth.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userService.signUp(request);
    }

    @PostMapping("/token")
    public TokenResponse logIn(@RequestBody @Valid UserSignInRequest request) {
        return userService.logIn(request);
    }

}
