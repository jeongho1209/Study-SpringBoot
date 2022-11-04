package com.example.fcm.domain.user.exception;

import com.example.fcm.global.error.CustomException;
import com.example.fcm.global.error.ErrorCode;

public class UserExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXIST);
    }

}
