package com.example.socket.domain.chat.exception;

import com.example.socket.global.error.CustomException;
import com.example.socket.global.error.ErrorCode;

public class AlreadyJoinException extends CustomException {

    public static final CustomException EXCEPTION =
            new AlreadyJoinException();

    private AlreadyJoinException() {
        super(ErrorCode.ALREADY_JOIN);
    }

}
