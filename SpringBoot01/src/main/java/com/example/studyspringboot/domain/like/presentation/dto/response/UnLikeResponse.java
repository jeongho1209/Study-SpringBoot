package com.example.studyspringboot.domain.like.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UnLikeResponse {

    private Integer unLikeCounts;
    private boolean unLiked;

}
