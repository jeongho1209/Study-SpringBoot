package com.example.studyspringboot.domain.auth.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class EmailCodeNotVerifiedException extends CustomException {

    public static final CustomException EXCEPTION =
            new EmailCodeNotVerifiedException();

    private EmailCodeNotVerifiedException() {
        super(ErrorCode.EMAIL_CODE_NOT_VERIFIED);
    }

}
