package com.example.oauth.domain.user.exception;

import com.example.oauth.global.error.CustomException;
import com.example.oauth.global.error.ErrorCode;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}
