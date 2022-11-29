package com.example.studyspringboot.domain.follow.service;

import com.example.studyspringboot.domain.follow.domain.Follow;
import com.example.studyspringboot.domain.follow.domain.repository.FollowRepository;
import com.example.studyspringboot.domain.follow.exception.CannotFollowYourselfException;
import com.example.studyspringboot.domain.follow.exception.FollowExistException;
import com.example.studyspringboot.domain.follow.facade.FollowFacade;
import com.example.studyspringboot.domain.follow.presentation.dto.FollowRequest;
import com.example.studyspringboot.domain.follow.presentation.dto.response.FollowResponse;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FollowUserService {

    private final FollowFacade followFacade;
    private final UserFacade userFacade;
    private final FollowRepository followRepository;

    @Transactional
    public FollowResponse execute(FollowRequest request) {
        User currentUser = userFacade.getCurrentUser();

        User targetUser = userFacade.getUserById(request.getTargetUserId());

        if (currentUser.getId().equals(targetUser.getId())) {
            throw CannotFollowYourselfException.EXCEPTION;
        }

        if (followFacade.checkFollowed(currentUser, targetUser)) {
            throw FollowExistException.EXCEPTION;
        }

        targetUser.addFollower();
        return addFollow(currentUser, targetUser);
    }

    private FollowResponse addFollow(User currentUser, User targetUser) {
        followRepository.save(Follow.builder()
                .user(currentUser)
                .targetUser(targetUser)
                .build());

        return FollowResponse.builder()
                .followed(followFacade.checkFollowed(currentUser, targetUser))
                .followCounts(currentUser.getFollowCounts())
                .build();
    }

}
