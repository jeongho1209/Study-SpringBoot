package com.example.studyspringboot.domain.feed.service;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.feed.domain.repository.FeedRepository;
import com.example.studyspringboot.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateFeedService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createFeed(CreateFeedRequest request) {
        User user = userFacade.getCurrentUser();

        feedRepository.save(Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .views(0)
                .likeCounts(0)
                .unLikeCounts(0)
                .user(user)
                .build());
    }

}
