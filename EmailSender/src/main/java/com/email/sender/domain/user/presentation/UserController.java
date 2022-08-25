package com.email.sender.domain.user.presentation;

import com.email.sender.domain.auth.presentation.dto.request.EmailVerifiedRequest;
import com.email.sender.domain.user.presentation.dto.request.UserSignUpRequest;
import com.email.sender.domain.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserSignUpService userService;

    @PostMapping("/email")
    public void verifyAccount(@RequestBody @Valid EmailVerifiedRequest request) {
        userService.verifyAccount(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userService.signUp(request);
    }

}
