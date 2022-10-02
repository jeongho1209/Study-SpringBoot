package com.example.socket.domain.chat.domain.repository;

import com.example.socket.domain.chat.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
