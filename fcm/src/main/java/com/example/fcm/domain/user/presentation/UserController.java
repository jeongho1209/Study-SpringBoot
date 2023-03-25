package com.example.fcm.domain.user.presentation;

import com.example.fcm.domain.auth.presentation.dto.response.TokenResponse;
import com.example.fcm.domain.user.presentation.dto.request.UserSignInRequest;
import com.example.fcm.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.fcm.domain.user.presentation.dto.response.QueryUserListResponse;
import com.example.fcm.domain.user.service.UserService;
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
    public TokenResponse signUp(@RequestBody @Valid UserSignUpRequest request) {
        return userService.execute(request);
    }

    @PostMapping("/token")
    public TokenResponse signIn(@RequestBody @Valid UserSignInRequest request) {
        return userService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void userWithdrawal() {
        userService.userWithdrawal();
    }

    @GetMapping
    public QueryUserListResponse queryUserList() {
        return userService.execute();
    }
}
