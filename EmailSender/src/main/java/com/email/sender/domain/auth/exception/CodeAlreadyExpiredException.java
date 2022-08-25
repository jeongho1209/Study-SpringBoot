package com.email.sender.domain.auth.exception;

import com.email.sender.global.error.CustomException;
import com.email.sender.global.error.ErrorCode;

public class CodeAlreadyExpiredException extends CustomException {

    public static final CustomException EXCEPTION =
            new CodeAlreadyExpiredException();

    private CodeAlreadyExpiredException() {
        super(ErrorCode.CODE_ALREADY_EXPIRED);
    }

}
