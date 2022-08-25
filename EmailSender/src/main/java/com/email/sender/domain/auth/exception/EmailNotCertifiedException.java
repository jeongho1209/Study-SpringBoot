package com.email.sender.domain.auth.exception;

import com.email.sender.global.error.CustomException;
import com.email.sender.global.error.ErrorCode;

public class EmailNotCertifiedException extends CustomException {

    public static final CustomException EXCEPTION =
            new EmailNotCertifiedException();

    private EmailNotCertifiedException() {
        super(ErrorCode.EMAIL_NOT_CERTIFIED);
    }

}
