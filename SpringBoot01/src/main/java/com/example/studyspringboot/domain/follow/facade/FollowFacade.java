package com.example.studyspringboot.domain.follow.facade;

import com.example.studyspringboot.domain.follow.domain.repository.FollowRepository;
import com.example.studyspringboot.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FollowFacade {

    private final FollowRepository followRepository;

    public boolean checkFollowed(User currentUser, User targetUser) {
        return followRepository.existsByUserAndTargetUser(currentUser, targetUser);
    }

}
