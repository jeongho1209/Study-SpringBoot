package com.example.fcm.domain.chat.presentation.dto.response;

import com.example.fcm.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryRoomDetailResponse {

    private final Long roomId;
    private final String roomName;
    private final int roomUserCount;
    private final UserResponse userResponse;

}
