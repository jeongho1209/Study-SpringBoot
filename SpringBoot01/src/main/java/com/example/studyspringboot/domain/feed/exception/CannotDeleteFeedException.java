package com.example.studyspringboot.domain.feed.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class CannotDeleteFeedException extends CustomException {

    public static final CustomException EXCEPTION =
            new CannotDeleteFeedException();

    private CannotDeleteFeedException() {
        super(ErrorCode.CANNOT_DELETE_FEED);
    }

}
