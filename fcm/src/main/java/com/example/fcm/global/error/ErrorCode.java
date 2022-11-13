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
    PASSWORD_MIS_MATCH(401, "Password Mis Match"),
    CANNOT_DELETE_ROOM(401, "Cannot Delete Room"),
    CANNOT_JOIN_ROOM(401, "Cannot Join Room"),

    FEIGN_FORBIDDEN(403, "Feign Forbidden"),

    USER_NOT_FOUND(404, "User Not Found"),
    ROOM_NOT_FOUND(404, "Room Not Found"),
    ROOM_USER_NOT_FOUND(404, "Room User Not Found"),

    USER_EXIST(409, "User Exist"),
    ROOM_USER_EXIST(409, "Room User Exist"),

    FEIGN_EXPIRED_TOKEN(419, "Feign Expired Token"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;

}
