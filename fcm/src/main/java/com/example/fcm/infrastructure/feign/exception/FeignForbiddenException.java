package com.example.fcm.infrastructure.feign.exception;

import com.example.fcm.global.error.CustomException;
import com.example.fcm.global.error.ErrorCode;

public class FeignForbiddenException extends CustomException {

    public static final CustomException EXCEPTION =
            new FeignForbiddenException();

    private FeignForbiddenException() {
        super(ErrorCode.FEIGN_FORBIDDEN);
    }

}
