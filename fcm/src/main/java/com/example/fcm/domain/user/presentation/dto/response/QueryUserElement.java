package com.example.fcm.domain.user.presentation.dto.response;

import com.example.fcm.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryUserElement {

    private final String email;
    private final String name;

    public static QueryUserElement of(User user) {
        return new QueryUserElement(
                user.getEmail(),
                user.getName()
        );
    }

}
