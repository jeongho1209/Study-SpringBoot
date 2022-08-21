package com.email.sender.exception;

import com.email.sender.error.CustomException;
import com.email.sender.error.ErrorCode;

public class CodeNotCorrectException extends CustomException {

    public static final CustomException EXCEPTION =
            new CodeNotCorrectException();

    private CodeNotCorrectException() {
        super(ErrorCode.CODE_NOT_CORRECT);
    }

}
