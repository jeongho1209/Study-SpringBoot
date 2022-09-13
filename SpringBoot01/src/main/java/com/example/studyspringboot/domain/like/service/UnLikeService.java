package com.example.studyspringboot.domain.like.service;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.feed.facade.FeedFacade;
import com.example.studyspringboot.domain.like.domain.Like;
import com.example.studyspringboot.domain.like.domain.repository.UnLikeRepository;
import com.example.studyspringboot.domain.like.exception.RemoveUnlikeExistException;
import com.example.studyspringboot.domain.like.exception.UnlikeExistException;
import com.example.studyspringboot.domain.like.facade.LikeFacade;
import com.example.studyspringboot.domain.like.presentation.dto.response.UnLikeResponse;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UnLikeService {

    private final UnLikeRepository unLikeRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;
    private final LikeFacade likeFacade;

    @Transactional
    public UnLikeResponse unLiked(Integer feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(feedId);

        if (likeFacade.checkUnLiked(user, feed)) {
            throw UnlikeExistException.EXCEPTION;
        }

        feed.addUnLikeCount();
        return addUnLike(user, feed);
    }

    @Transactional
    public UnLikeResponse deleteUnLiked(Integer feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(feedId);

        if (!likeFacade.checkLiked(user, feed)) {
            throw RemoveUnlikeExistException.EXCEPTION;
        }

        feed.minusUnLikeCount();
        return removeUnLike(user, feed);
    }

    private UnLikeResponse addUnLike(User user, Feed feed) {
        unLikeRepository.save(Like.builder()
                .user(user)
                .feed(feed)
                .build());

        return UnLikeResponse.builder()
                .unLikeCounts(feed.getUnLikeCounts())
                .unLiked(likeFacade.checkUnLiked(user, feed))
                .build();
    }

    private UnLikeResponse removeUnLike(User user, Feed feed) {

        unLikeRepository.deleteByUserAndFeed(user, feed);

        return UnLikeResponse.builder()
                .unLikeCounts(feed.getUnLikeCounts())
                .unLiked(likeFacade.checkUnLiked(user, feed))
                .build();
    }

}
