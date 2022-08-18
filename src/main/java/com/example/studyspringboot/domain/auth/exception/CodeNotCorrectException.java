package com.example.studyspringboot.domain.auth.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class CodeNotCorrectException extends CustomException {

    public static final CodeNotCorrectException EXCEPTION =
            new CodeNotCorrectException();

    private CodeNotCorrectException() {
        super(ErrorCode.CODE_NOT_CORRECT);
    }

}
