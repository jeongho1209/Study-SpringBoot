package com.example.fcm.infrastructure.feign.exception;

import com.example.fcm.global.error.CustomException;
import com.example.fcm.global.error.ErrorCode;

public class FeignUnAuthorizedException extends CustomException {

    public static final CustomException EXCEPTION =
            new FeignUnAuthorizedException();

    private FeignUnAuthorizedException() {
        super(ErrorCode.FEIGN_UN_AUTHORIZED);
    }

}
