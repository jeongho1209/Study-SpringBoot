package com.example.fcm.domain.chat.service;

import com.example.fcm.domain.chat.domain.room.RoomRepository;
import com.example.fcm.domain.chat.presentation.dto.response.QueryRoomListResponse;
import com.example.fcm.domain.chat.presentation.dto.response.RoomElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryRoomListService {

    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public QueryRoomListResponse execute() {
        List<RoomElement> roomList = roomRepository.findRoomsByOrderByIdDesc()
                .stream()
                .map(RoomElement::of)
                .collect(Collectors.toList());

        return new QueryRoomListResponse(roomList);
    }

}
