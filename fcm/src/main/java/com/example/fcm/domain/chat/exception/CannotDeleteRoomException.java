package com.example.fcm.domain.chat.exception;

import com.example.fcm.global.error.CustomException;
import com.example.fcm.global.error.ErrorCode;

public class CannotDeleteRoomException extends CustomException {

    public static final CustomException EXCEPTION = new CannotDeleteRoomException();

    private CannotDeleteRoomException() {
        super(ErrorCode.CANNOT_DELETE_ROOM);
    }

}
