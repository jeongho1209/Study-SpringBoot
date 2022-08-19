package com.example.studyspringboot.domain.auth.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class CodeAlreadyExpiredException extends CustomException {

    public static final CustomException EXCEPTION =
            new CodeAlreadyExpiredException();

    private CodeAlreadyExpiredException() {
        super(ErrorCode.CODE_ALREADY_EXPIRED);
    }

}
