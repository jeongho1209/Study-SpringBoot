package com.example.socket.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    PASSWORD_MIS_MATCH(401, "Password Mis Match"),

    USER_NOT_FOUND(404, "User Not Found"),
    ROOM_NOT_FOUND(404, "Room Not Found"),
    MEMBER_NOT_FOUND(404, "Member Not Found"),

    USER_EXISTS(409, "User Exists"),
    ALREADY_JOIN(409, "Already Join"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;

}
