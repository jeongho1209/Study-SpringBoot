package com.example.fcm.domain.chat.service;

import com.example.fcm.domain.chat.domain.room.Room;
import com.example.fcm.domain.chat.domain.room.RoomRepository;
import com.example.fcm.domain.chat.exception.CannotDeleteRoomException;
import com.example.fcm.domain.chat.facade.RoomFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteRoomService {

    private final RoomRepository roomRepository;
    private final RoomFacade roomFacade;

    @Transactional
    public void execute(Long roomId) {
        Room room = roomFacade.getRoom(roomId);

        boolean isCheckExistRoomUsers = room.getRoomUsers().size() != 0;

        if (isCheckExistRoomUsers) {
            throw CannotDeleteRoomException.EXCEPTION;
        }

        roomRepository.delete(room);
    }
}
