package com.example.studyspringboot.domain.user.presentation.dto.response;

import com.example.studyspringboot.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryUserElement {

    private final String accountId;
    private final String name;

    public static QueryUserElement of(User user) {
        return QueryUserElement.builder()
                .accountId(user.getAccountId())
                .name(user.getName())
                .build();
    }

}
