package com.example.socket.domain.chat.domain.repository;

import com.example.socket.domain.chat.domain.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {
}
