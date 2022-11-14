package com.example.fcm.domain.chat.facade;

import com.example.fcm.domain.chat.domain.room.Room;
import com.example.fcm.domain.chat.domain.roomuser.RoomUser;
import com.example.fcm.domain.chat.domain.roomuser.RoomUserRepository;
import com.example.fcm.domain.chat.exception.RoomUserNotFoundException;
import com.example.fcm.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoomUserFacade {

    private final RoomUserRepository roomUserRepository;

    public RoomUser getRoomUser(User user, Room room) {
        return roomUserRepository.findByUserAndRoom(user, room)
                .orElseThrow(() -> RoomUserNotFoundException.EXCEPTION);
    }

    public boolean existUser(User user, Room room) {
        return roomUserRepository.existsByUserAndRoom(user, room);
    }

}
