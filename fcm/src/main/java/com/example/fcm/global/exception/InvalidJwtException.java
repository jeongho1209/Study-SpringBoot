package com.example.fcm.global.exception;

import com.example.fcm.global.error.CustomException;
import com.example.fcm.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }

}
