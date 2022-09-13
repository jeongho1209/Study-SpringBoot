package com.example.studyspringboot.domain.follow.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FollowResponse {

    private Integer followCounts;
    private boolean followed;

}
