package com.example.socket.domain.chat.exception;

import com.example.socket.global.error.CustomException;
import com.example.socket.global.error.ErrorCode;

public class MemberNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new MemberNotFoundException();

    private MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }

}
