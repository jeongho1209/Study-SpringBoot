package com.email.sender.controller;

import com.email.sender.controller.dto.request.EmailVerifiedRequest;
import com.email.sender.controller.dto.request.UserSignUpRequest;
import com.email.sender.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

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
