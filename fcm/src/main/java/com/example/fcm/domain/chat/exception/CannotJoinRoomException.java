package com.example.fcm.domain.chat.exception;

import com.example.fcm.global.error.CustomException;
import com.example.fcm.global.error.ErrorCode;

public class CannotJoinRoomException extends CustomException {

    public static final CustomException EXCEPTION = new CannotJoinRoomException();

    private CannotJoinRoomException() {
        super(ErrorCode.CANNOT_JOIN_ROOM);
    }

}
