package com.example.studyspringboot.domain.user.presentation;

import com.example.studyspringboot.domain.user.presentation.dto.request.ChangePasswordRequest;
import com.example.studyspringboot.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.example.studyspringboot.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.studyspringboot.domain.user.presentation.dto.response.QueryMyInfoResponse;
import com.example.studyspringboot.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserSignUpService userSignUpService;
    private final QueryMyInfoService queryMyInfoService;
    private final UpdateUserInfoService updateUserInfoService;
    private final ChangePasswordService changePasswordService;
    private final UserWithdrawalService userWithdrawalService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.signUp(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping
    public void modifyInfo(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.modifyInfo(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/password")
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        changePasswordService.changePassword(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteUser() {
        userWithdrawalService.deleteUser();
    }

    @GetMapping
    public QueryMyInfoResponse getMyInfo() {
        return queryMyInfoService.getMyInfo();
    }

}
