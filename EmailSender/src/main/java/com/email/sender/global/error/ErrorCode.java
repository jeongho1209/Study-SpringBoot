package com.email.sender.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    CODE_ALREADY_EXPIRED(401, "Code Already Expired"),
    EMAIL_NOT_CERTIFIED(401, "Email Not Certified"),
    CODE_NOT_CORRECT(401, "Code Not Correct"),

    USER_EXIST(409, "User Exist"),

    SEND_MESSAGE_FAILED(500, "Send Message Failed"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;

}
