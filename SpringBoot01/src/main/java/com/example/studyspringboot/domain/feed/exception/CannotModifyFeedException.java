package com.example.studyspringboot.domain.feed.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class CannotModifyFeedException extends CustomException {

    public static final CustomException EXCEPTION =
            new CannotModifyFeedException();

    private CannotModifyFeedException() {
        super(ErrorCode.CANNOT_MODIFY_FEED);
    }

}
