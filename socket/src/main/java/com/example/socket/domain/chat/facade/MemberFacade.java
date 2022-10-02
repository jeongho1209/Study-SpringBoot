package com.example.socket.domain.chat.facade;

import com.example.socket.domain.chat.domain.Room;
import com.example.socket.domain.chat.domain.repository.MemberRepository;
import com.example.socket.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberFacade {

    private final MemberRepository memberRepository;

    public boolean checkRoomUserExist(Room room, User user) {
        return memberRepository.existsByRoomAndUser(room, user);
    }

}
