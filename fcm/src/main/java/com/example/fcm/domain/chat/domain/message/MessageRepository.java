package com.example.fcm.domain.chat.domain.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("select m from Message m where m.room.id = :roomId")
    List<Message> queryMessagesByRoom(Long roomId);


}
