package com.example.fcm.domain.chat.exception;

import com.example.fcm.global.error.CustomException;
import com.example.fcm.global.error.ErrorCode;

public class RoomUserExistException extends CustomException {

    public static final CustomException EXCEPTION = new RoomUserExistException();

    private RoomUserExistException() {
        super(ErrorCode.ROOM_USER_EXIST);
    }

}
