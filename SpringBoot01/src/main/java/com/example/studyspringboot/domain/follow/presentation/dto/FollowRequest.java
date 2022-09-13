package com.example.studyspringboot.domain.follow.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class FollowRequest {

    @NotNull
    private Integer targetUserId;

}
