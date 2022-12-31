package com.example.fcm.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private final Long userId;
    private final String userName;

}
