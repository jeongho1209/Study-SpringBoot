package com.example.studyspringboot.domain.follow.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class FollowExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new FollowExistException();

    private FollowExistException() {
        super(ErrorCode.FOLLOW_EXIST);
    }

}