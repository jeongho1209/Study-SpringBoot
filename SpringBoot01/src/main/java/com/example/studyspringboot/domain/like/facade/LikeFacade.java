package com.example.studyspringboot.domain.like.facade;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.like.domain.repository.LikeRepository;
import com.example.studyspringboot.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikeFacade {

    private final LikeRepository likeRepository;

    public boolean checkLiked(User user, Feed feed) {
        return likeRepository.existsByUserAndFeed(user, feed);
    }

}
