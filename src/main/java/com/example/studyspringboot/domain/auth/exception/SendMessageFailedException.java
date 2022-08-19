package com.example.studyspringboot.domain.auth.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class SendMessageFailedException extends CustomException {

    public static final CustomException EXCEPTION =
            new SendMessageFailedException();

    private SendMessageFailedException() {
        super(ErrorCode.SEND_MESSAGE_FAILED);
    }

}
