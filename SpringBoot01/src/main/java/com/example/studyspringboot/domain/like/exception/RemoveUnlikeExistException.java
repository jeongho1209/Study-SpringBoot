package com.example.studyspringboot.domain.like.exception;

import com.example.studyspringboot.global.error.CustomException;
import com.example.studyspringboot.global.error.ErrorCode;

public class RemoveUnlikeExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new RemoveUnlikeExistException();

    private RemoveUnlikeExistException() {
        super(ErrorCode.REMOVE_UNLIKE_EXIST);
    }
    
}
