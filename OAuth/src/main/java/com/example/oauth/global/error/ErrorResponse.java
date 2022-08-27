package com.example.oauth.global.error;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ErrorResponse {

    private final int status;
    private final String message;

}
