package com.example.fcm.domain.chat.presentation;

import com.example.fcm.domain.chat.presentation.dto.request.QueryRoomRequest;
import com.example.fcm.domain.chat.presentation.dto.response.QueryMessageListResponse;
import com.example.fcm.domain.chat.presentation.dto.response.QueryRoomDetailResponse;
import com.example.fcm.domain.chat.presentation.dto.response.QueryRoomListResponse;
import com.example.fcm.domain.chat.service.DeleteRoomService;
import com.example.fcm.domain.chat.service.QueryMessageListService;
import com.example.fcm.domain.chat.service.QueryRoomDetailService;
import com.example.fcm.domain.chat.service.QueryRoomListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/chat")
@RestController
public class ChatController {

    private final QueryRoomListService queryRoomListService;
    private final QueryMessageListService queryMessageListService;
    private final QueryRoomDetailService queryRoomDetailService;
    private final DeleteRoomService deleteRoomService;

    @GetMapping("/room")
    public QueryRoomListResponse queryRoomList() {
        return queryRoomListService.execute();
    }

    @GetMapping
    public QueryMessageListResponse queryMessageList(@RequestBody QueryRoomRequest request) {
        return queryMessageListService.execute(request);
    }

    @GetMapping("/{room-id}")
    public QueryRoomDetailResponse queryRoomDetail(@PathVariable("room-id") Long roomId) {
        return queryRoomDetailService.execute(roomId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{room-id}")
    public void deleteRoom(@PathVariable("room-id") Long roomId) {
        deleteRoomService.execute(roomId);
    }

}

