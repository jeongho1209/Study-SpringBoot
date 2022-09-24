package com.example.categoryboard.service;

import com.example.categoryboard.entity.Feed;
import com.example.categoryboard.presentation.dto.request.CreateFeedRequest;
import com.example.categoryboard.presentation.dto.request.UpdateFeedRequest;
import com.example.categoryboard.repository.FeedRepository;
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
                .title(request.getTitle())
                .content(request.getContent())
                .category(request.getCategory())
                .build());
    }

}
