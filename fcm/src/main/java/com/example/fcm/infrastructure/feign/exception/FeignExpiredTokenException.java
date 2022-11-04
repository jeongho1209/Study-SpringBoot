package com.example.fcm.infrastructure.feign.exception;

import com.example.fcm.global.error.CustomException;
import com.example.fcm.global.error.ErrorCode;

public class FeignExpiredTokenException extends CustomException {

    public static final CustomException EXCEPTION =
            new FeignExpiredTokenException();

    private FeignExpiredTokenException() {
        super(ErrorCode.FEIGN_EXPIRED_TOKEN);
    }

}
