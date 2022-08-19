package com.example.studyspringboot.domain.auth.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class PasswordMisMatchException extends CustomException {

    public static final CustomException EXCEPTION =
            new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MIS_MATCH);
    }

}
