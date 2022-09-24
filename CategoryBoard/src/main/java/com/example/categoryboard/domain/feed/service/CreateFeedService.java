package com.example.categoryboard.domain.feed.service;

import com.example.categoryboard.domain.feed.domain.Feed;
import com.example.categoryboard.domain.feed.domain.repository.FeedRepository;
import com.example.categoryboard.domain.feed.presentation.dto.request.CreateFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void createFeed(CreateFeedRequest request) {
        feedRepository.save(Feed.builder()
                .title(request.getContent())
                .content(request.getContent())
                .category(request.getCategory())
                .build());
    }

}
