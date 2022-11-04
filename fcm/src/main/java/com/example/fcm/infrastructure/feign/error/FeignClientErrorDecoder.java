package com.example.fcm.infrastructure.feign.error;

import com.example.fcm.infrastructure.feign.exception.FeignBadRequestException;
import com.example.fcm.infrastructure.feign.exception.FeignExpiredTokenException;
import com.example.fcm.infrastructure.feign.exception.FeignForbiddenException;
import com.example.fcm.infrastructure.feign.exception.FeignUnAuthorizedException;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) throws FeignException {

        if (response.status() >= 400) {
            switch (response.status()) {
                case 401:
                    throw FeignUnAuthorizedException.EXCEPTION;
                case 403:
                    throw FeignForbiddenException.EXCEPTION;
                case 419:
                    throw FeignExpiredTokenException.EXCEPTION;
                default:
                    throw FeignBadRequestException.EXCEPTION;
            }
        }
        return FeignException.errorStatus(methodKey, response);
    }

}
