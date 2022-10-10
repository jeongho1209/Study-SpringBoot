package com.example.studyspringboot.domain.feed.service;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.feed.exception.CannotModifyFeedException;
import com.example.studyspringboot.domain.feed.facade.FeedFacade;
import com.example.studyspringboot.domain.feed.presentation.dto.request.UpdateFeedRequest;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateFeedService {

    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void execute(Integer feedId, UpdateFeedRequest request) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(feedId);

        if (!user.equals(feed.getUser())) {
            throw CannotModifyFeedException.EXCEPTION;
        }

        feed.modifyFeed(request.getTitle(), request.getContent());
    }

}
