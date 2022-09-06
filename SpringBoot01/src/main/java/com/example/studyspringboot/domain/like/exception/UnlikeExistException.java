package com.example.studyspringboot.domain.like.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class UnlikeExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new UnlikeExistException();

    private UnlikeExistException() {
        super(ErrorCode.UNLIKE_EXIST);
    }

}
