package com.example.fcm.domain.user.presentation;

import com.example.fcm.domain.auth.presentation.dto.response.TokenResponse;
import com.example.fcm.domain.user.presentation.dto.request.UserSignInRequest;
import com.example.fcm.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.fcm.domain.user.presentation.dto.response.QueryUserListResponse;
import com.example.fcm.domain.user.service.QueryUserListService;
import com.example.fcm.domain.user.service.UserSignInService;
import com.example.fcm.domain.user.service.UserSignUpService;
import com.example.fcm.domain.user.service.UserWithdrawalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;
    private final UserWithdrawalService userWithdrawalService;
    private final QueryUserListService queryUserListService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public TokenResponse signUp(@RequestBody @Valid UserSignUpRequest request) {
        return userSignUpService.execute(request);
    }

    @PostMapping("/token")
    public TokenResponse signIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteUser() {
        userWithdrawalService.execute();
    }

    @GetMapping
    public QueryUserListResponse queryUserList() {
        return queryUserListService.execute();
    }

}
