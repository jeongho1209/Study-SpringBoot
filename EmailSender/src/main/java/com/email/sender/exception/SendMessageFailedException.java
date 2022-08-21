package com.email.sender.exception;

import com.email.sender.error.CustomException;
import com.email.sender.error.ErrorCode;

public class SendMessageFailedException extends CustomException {

    public static final CustomException EXCEPTION =
            new SendMessageFailedException();

    private SendMessageFailedException() {
        super(ErrorCode.SEND_MESSAGE_FAILED);
    }

}
