package com.example.studyspringboot.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class QueryAnotherUserInfoRequest {

    @NotNull
    private Integer userId;

}
