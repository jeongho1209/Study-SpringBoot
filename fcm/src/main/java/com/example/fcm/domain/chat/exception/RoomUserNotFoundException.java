package com.example.fcm.domain.chat.exception;

import com.example.fcm.global.error.CustomException;
import com.example.fcm.global.error.ErrorCode;

public class RoomUserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new RoomUserNotFoundException();

    private RoomUserNotFoundException() {
        super(ErrorCode.ROOM_USER_NOT_FOUND);
    }

}
