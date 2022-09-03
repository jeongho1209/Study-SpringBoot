package com.example.studyspringboot.domain.like.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LikeResponse {

    private Integer likeCounts;
    private boolean liked;

}
