package com.example.oauth.global.exception;

import com.example.oauth.global.error.CustomException;
import com.example.oauth.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }

}
