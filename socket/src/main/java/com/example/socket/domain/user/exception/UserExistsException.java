package com.example.socket.domain.user.exception;

import com.example.socket.global.error.CustomException;
import com.example.socket.global.error.ErrorCode;

public class UserExistsException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserExistsException();

    private UserExistsException() {
        super(ErrorCode.USER_EXISTS);
    }

}
