package com.example.socket.domain.chat.exception;

import com.example.socket.global.error.CustomException;
import com.example.socket.global.error.ErrorCode;

public class RoomUserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new RoomUserNotFoundException();

    private RoomUserNotFoundException() {
        super(ErrorCode.ROOM_USER_NOT_FOUND);
    }

}
