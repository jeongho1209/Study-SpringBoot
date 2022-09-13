package com.example.studyspringboot.domain.follow.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class CannotFollowYourselfException extends CustomException {

    public static final CustomException EXCEPTION =
            new CannotFollowYourselfException();

    private CannotFollowYourselfException() {
        super(ErrorCode.CANNOT_FOLLOW_YOURSELF);
    }

}
