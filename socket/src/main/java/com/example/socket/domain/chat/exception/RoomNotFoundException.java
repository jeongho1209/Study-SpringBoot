package com.example.socket.domain.chat.exception;

import com.example.socket.global.error.CustomException;
import com.example.socket.global.error.ErrorCode;

public class RoomNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new RoomNotFoundException();

    private RoomNotFoundException() {
        super(ErrorCode.ROOM_NOT_FOUND);
    }

}
