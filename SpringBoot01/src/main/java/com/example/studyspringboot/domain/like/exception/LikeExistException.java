package com.example.studyspringboot.domain.like.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class LikeExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new LikeExistException();

    private LikeExistException() {
        super(ErrorCode.LIKE_EXIST);
    }

}

