package com.email.sender.exception;

import com.email.sender.error.CustomException;
import com.email.sender.error.ErrorCode;

public class UserExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXIST);
    }

}
