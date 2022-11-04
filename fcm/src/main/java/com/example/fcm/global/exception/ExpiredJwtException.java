package com.example.fcm.global.exception;

import com.example.fcm.global.error.CustomException;
import com.example.fcm.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }

}
