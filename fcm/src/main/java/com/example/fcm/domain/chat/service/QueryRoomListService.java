package com.example.fcm.domain.chat.service;

import com.example.fcm.domain.chat.domain.room.RoomRepository;
import com.example.fcm.domain.chat.facade.RoomFacade;
import com.example.fcm.domain.chat.presentation.dto.response.QueryRoomListResponse;
import com.example.fcm.domain.chat.presentation.dto.response.RoomElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryRoomListService {

    private final RoomRepository roomRepository;
    private final RoomFacade roomFacade;

    @Transactional(readOnly = true)
    public QueryRoomListResponse execute() {

        return new QueryRoomListResponse(
                roomRepository.findRoomsByOrderByIdDesc()
                        .stream()
                        .filter(roomFacade::isNotFullRoom)
                        .map(RoomElement::of)
                        .collect(Collectors.toList())
        );
    }

}
