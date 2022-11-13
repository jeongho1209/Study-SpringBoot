package com.example.fcm.domain.chat.domain.roomuser;

import com.example.fcm.domain.chat.domain.room.Room;
import com.example.fcm.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomUserRepository extends JpaRepository<RoomUser, Long> {

    Optional<RoomUser> findByUserAndRoom(User user, Room room);

    boolean existsByUserAndRoom(User user, Room room);

}
