package com.email.sender.exception;

import com.email.sender.error.CustomException;
import com.email.sender.error.ErrorCode;

public class EmailNotCertifiedException extends CustomException {

    public static final CustomException EXCEPTION =
            new EmailNotCertifiedException();

    private EmailNotCertifiedException() {
        super(ErrorCode.EMAIL_NOT_CERTIFIED);
    }

}
