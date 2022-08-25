package com.email.sender.domain.auth.exception;

import com.email.sender.global.error.CustomException;
import com.email.sender.global.error.ErrorCode;

public class CodeNotCorrectException extends CustomException {

    public static final CustomException EXCEPTION =
            new CodeNotCorrectException();

    private CodeNotCorrectException() {
        super(ErrorCode.CODE_NOT_CORRECT);
    }

}
