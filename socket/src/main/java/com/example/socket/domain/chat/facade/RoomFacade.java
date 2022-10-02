package com.example.socket.domain.chat.facade;

import com.example.socket.domain.chat.domain.Room;
import com.example.socket.domain.chat.domain.repository.RoomRepository;
import com.example.socket.domain.chat.exception.RoomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoomFacade {

    private final RoomRepository roomRepository;

    public Room getRoom(Integer roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);
    }

}
