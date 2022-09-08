package com.example.socket.global.exception;

import com.example.socket.global.error.CustomException;
import com.example.socket.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }

}
