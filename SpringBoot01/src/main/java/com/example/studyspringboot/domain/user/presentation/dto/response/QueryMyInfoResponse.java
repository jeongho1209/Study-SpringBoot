package com.example.studyspringboot.domain.user.presentation.dto.response;

import com.example.studyspringboot.domain.user.domain.type.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryMyInfoResponse {

    private final Sex sex;
    private final String introduce;
    private final String name;

}
