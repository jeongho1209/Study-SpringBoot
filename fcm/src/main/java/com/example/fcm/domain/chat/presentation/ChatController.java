package com.example.fcm.domain.chat.presentation;

import com.example.fcm.domain.chat.presentation.dto.response.QueryRoomListResponse;
import com.example.fcm.domain.chat.service.DeleteRoomService;
import com.example.fcm.domain.chat.service.QueryRoomListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/chat")
@RestController
public class ChatController {

    private final QueryRoomListService queryRoomListService;
    private final DeleteRoomService deleteRoomService;

    @GetMapping("/room")
    public QueryRoomListResponse queryRoomList() {
        return queryRoomListService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{room-id}")
    public void deleteRoom(@PathVariable("room-id") Long roomId) {
        deleteRoomService.execute(roomId);
    }

}

