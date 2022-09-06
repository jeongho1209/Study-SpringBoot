package com.example.studyspringboot.domain.like.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class RemoveLikeExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new RemoveLikeExistException();

    private RemoveLikeExistException() {
        super(ErrorCode.REMOVE_LIKE_EXIST);
    }

}
