package com.example.studyspringboot.domain.user.presentation;

import com.example.studyspringboot.domain.user.presentation.dto.request.ChangePasswordRequest;
import com.example.studyspringboot.domain.user.presentation.dto.request.QueryAnotherUserInfoRequest;
import com.example.studyspringboot.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.example.studyspringboot.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.studyspringboot.domain.user.presentation.dto.response.QueryUserInfoResponse;
import com.example.studyspringboot.domain.user.presentation.dto.response.QueryUserListResponse;
import com.example.studyspringboot.domain.user.service.*;
import io.swagger.v3.oas.annotations.Operation;
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
    private final QueryAnotherUserInfoService queryAnotherUserInfoService;
    private final UpdateUserInfoService updateUserInfoService;
    private final ChangePasswordService changePasswordService;
    private final UserWithdrawalService userWithdrawalService;
    private final QueryUserListService queryUserListService;

    @Operation(summary = "회원가입")
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
    public QueryUserInfoResponse getMyInfo() {
        return queryMyInfoService.getMyInfo();
    }

    @GetMapping("/info")
    public QueryUserInfoResponse getAnotherInfo(QueryAnotherUserInfoRequest request) {
        return queryAnotherUserInfoService.execute(request);
    }

    @GetMapping("/all")
    public QueryUserListResponse getUserList(@RequestParam Integer key) {
        return queryUserListService.execute(key);
    }

}
