package com.example.studyspringboot.domain.auth.presentation;

import com.example.studyspringboot.domain.auth.presentation.dto.request.EmailVerifiedRequest;
import com.example.studyspringboot.domain.auth.service.VerifyEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final VerifyEmailService sendEmailService;

    @PostMapping("/verify")
    public void verifyAccount(@RequestBody @Valid EmailVerifiedRequest request) {
        sendEmailService.verifyAccount(request);
    }

}
