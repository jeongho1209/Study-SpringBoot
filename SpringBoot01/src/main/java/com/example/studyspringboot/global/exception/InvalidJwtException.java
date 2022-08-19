package com.example.studyspringboot.global.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }

}
