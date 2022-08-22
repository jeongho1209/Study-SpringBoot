package com.example.studyspringboot.domain.user.presentation;

import com.example.studyspringboot.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.example.studyspringboot.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.studyspringboot.domain.user.service.UpdateUserInfoService;
import com.example.studyspringboot.domain.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UpdateUserInfoService updateUserInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.signUp(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    public void modifyInfo(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.modifyInfo(request);
    }

}
