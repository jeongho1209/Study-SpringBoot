package com.example.studyspringboot.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    INVALID_REFRESH_TOKEN(401, "Invalid Refresh Token"),
    PASSWORD_MIS_MATCH(401, "Password Mis Match"),
    EMAIL_CODE_NOT_VERIFIED(401, "Email Code Not Verified"),
    CANNOT_FOLLOW_YOURSELF(401, "Cannot Follow Yourself"),
    CODE_NOT_CORRECT(401, "Code Not Correct"),
    CODE_ALREADY_EXPIRED(401, "Code Already Expired"),
    CANNOT_MODIFY_FEED(401, "Cannot Modify Feed"),

    USER_NOT_FOUND(404, "User Not Found"),
    EMAIL_CODE_NOT_FOUND(404, "Email Code Not Found"),
    FEED_NOT_FOUND(404, "Feed Not Found"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),

    USER_EXIST(409, "User Exist"),
    LIKE_EXIST(409, "Like Exist"),
    REMOVE_LIKE_EXIST(409, "Remove Like Exist"),
    UNLIKE_EXIST(409, "Unlike Exist"),
    REMOVE_UNLIKE_EXIST(409, "Remove Unlike Exist"),
    FOLLOW_EXIST(409, "Follow Exist"),

    SEND_MESSAGE_FAILED(500, "Send Message Failed"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;

}
