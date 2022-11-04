package com.example.fcm.global.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),

    FEIGN_UN_AUTHORIZED(401, "Feign Un Authorized"),
    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),

    FEIGN_FORBIDDEN(403, "Feign Forbidden"),

    USER_NOT_FOUND(404, "User Not Found"),

    USER_EXIST(409, "User Exist"),

    FEIGN_EXPIRED_TOKEN(419, "Feign Expired Token"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;

}
