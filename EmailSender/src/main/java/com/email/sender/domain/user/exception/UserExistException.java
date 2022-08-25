package com.email.sender.global.exception;

import com.email.sender.global.error.CustomException;
import com.email.sender.global.error.ErrorCode;

public class UserExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXIST);
    }

}
