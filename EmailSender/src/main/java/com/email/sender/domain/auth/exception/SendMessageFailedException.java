package com.email.sender.domain.auth.exception;

import com.email.sender.global.error.CustomException;
import com.email.sender.global.error.ErrorCode;

public class SendMessageFailedException extends CustomException {

    public static final CustomException EXCEPTION =
            new SendMessageFailedException();

    private SendMessageFailedException() {
        super(ErrorCode.SEND_MESSAGE_FAILED);
    }

}
