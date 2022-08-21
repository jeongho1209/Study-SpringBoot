package com.email.sender.exception;

import com.email.sender.error.CustomException;
import com.email.sender.error.ErrorCode;

public class CodeAlreadyExpiredException extends CustomException {

    public static final CustomException EXCEPTION =
            new CodeAlreadyExpiredException();

    private CodeAlreadyExpiredException() {
        super(ErrorCode.CODE_ALREADY_EXPIRED);
    }

}
