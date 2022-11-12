package com.example.fcm.domain.chat.exception;

import com.example.fcm.global.error.CustomException;
import com.example.fcm.global.error.ErrorCode;

public class RoomNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new RoomNotFoundException();

    private RoomNotFoundException() {
        super(ErrorCode.ROOM_NOT_FOUND);
    }

}
