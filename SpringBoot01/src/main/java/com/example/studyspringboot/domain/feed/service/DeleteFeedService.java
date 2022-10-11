package com.example.studyspringboot.domain.feed.service;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.feed.domain.repository.FeedRepository;
import com.example.studyspringboot.domain.feed.exception.CannotDeleteFeedException;
import com.example.studyspringboot.domain.feed.facade.FeedFacade;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFeedService {

    private final FeedFacade feedFacade;
    private final UserFacade userFacade;
    private final FeedRepository feedRepository;

    @Transactional
    public void execute(Integer feedId) {
        Feed feed = feedFacade.getFeed(feedId);
        User user = userFacade.getCurrentUser();

        if (!user.equals(feed.getUser())) {
            throw CannotDeleteFeedException.EXCEPTION;
        }

        feedRepository.delete(feed);
    }

}