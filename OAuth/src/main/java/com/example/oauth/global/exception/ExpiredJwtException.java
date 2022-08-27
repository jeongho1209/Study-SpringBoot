package com.example.oauth.global.exception;

import com.example.oauth.global.error.CustomException;
import com.example.oauth.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }

}
