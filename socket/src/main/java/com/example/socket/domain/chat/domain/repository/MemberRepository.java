package com.example.socket.domain.chat.domain.repository;

import com.example.socket.domain.chat.domain.Room;
import com.example.socket.domain.chat.domain.Member;
import com.example.socket.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    boolean existsByRoomAndUser(Room room, User user);

}
