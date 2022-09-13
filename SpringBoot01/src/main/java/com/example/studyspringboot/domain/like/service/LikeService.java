package com.example.studyspringboot.domain.like.service;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.feed.facade.FeedFacade;
import com.example.studyspringboot.domain.like.domain.Like;
import com.example.studyspringboot.domain.like.domain.repository.LikeRepository;
import com.example.studyspringboot.domain.like.exception.LikeExistException;
import com.example.studyspringboot.domain.like.exception.RemoveLikeExistException;
import com.example.studyspringboot.domain.like.facade.LikeFacade;
import com.example.studyspringboot.domain.like.presentation.dto.response.LikeResponse;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;
    private final LikeFacade likeFacade;

    @Transactional
    public LikeResponse liked(Integer feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(feedId);

        if (likeFacade.checkLiked(user, feed)) {
            throw LikeExistException.EXCEPTION;
        }

        feed.addLikeCount();
        return addLike(user, feed);
    }

    @Transactional
    public LikeResponse deleteLiked(Integer feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(feedId);

        if (!likeFacade.checkLiked(user, feed)) {
            throw RemoveLikeExistException.EXCEPTION;
        }

        feed.minusLikeCount();
        return removeLike(user, feed);
    }

    private LikeResponse addLike(User user, Feed feed) {
        likeRepository.save(Like.builder()
                .user(user)
                .feed(feed)
                .build());

        return LikeResponse.builder()
                .likeCounts(feed.getLikeCounts())
                .liked(likeFacade.checkLiked(user, feed))
                .build();
    }

    private LikeResponse removeLike(User user, Feed feed) {

        likeRepository.deleteByUserAndFeed(user, feed);

        return LikeResponse.builder()
                .likeCounts(feed.getLikeCounts())
                .liked(likeFacade.checkLiked(user, feed))
                .build();
    }

}
