package com.example.studyspringboot.domain.auth.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class EmailCodeNotFoundException extends CustomException {

    public static final EmailCodeNotFoundException EXCEPTION =
            new EmailCodeNotFoundException();

    private EmailCodeNotFoundException() {
        super(ErrorCode.EMAIL_CODE_NOT_FOUND);
    }

}
