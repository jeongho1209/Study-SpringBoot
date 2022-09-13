package com.example.studyspringboot.domain.follow.presentation;

import com.example.studyspringboot.domain.follow.presentation.dto.FollowRequest;
import com.example.studyspringboot.domain.follow.presentation.dto.response.FollowResponse;
import com.example.studyspringboot.domain.follow.service.FollowUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/follow")
@RestController
public class FollowController {

    private final FollowUserService followUserService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping// todo 팔로우 수 추가하기
    public FollowResponse addFollow(@RequestBody @Valid FollowRequest request) {
        return followUserService.execute(request);
    }

}
