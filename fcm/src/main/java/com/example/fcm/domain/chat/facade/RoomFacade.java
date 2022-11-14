package com.example.fcm.domain.chat.facade;

import com.example.fcm.domain.chat.domain.room.Room;
import com.example.fcm.domain.chat.domain.room.RoomRepository;
import com.example.fcm.domain.chat.exception.CannotDeleteRoomException;
import com.example.fcm.domain.chat.exception.RoomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoomFacade {

    private final RoomRepository roomRepository;

    public Room getRoom(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);
    }

    public void checkRoom(Room room) {
        if (room.getRoomUsers().size() != 0) {
            throw CannotDeleteRoomException.EXCEPTION;
        }

        roomRepository.delete(room);
    }

    public boolean isNotFullRoom(Room room) {
        return 3 > room.getRoomUsers().size();
    }

}
