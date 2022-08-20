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
public class FeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void createFeed(CreateFeedRequest request) {
        feedRepository.save(Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .category(request.getCategory())
                .build());
    }

    @Transactional
    public void deleteFeed(Long feedId) {
        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(RuntimeException::new);

        feedRepository.delete(feed);
    }

    @Transactional
    public void modifyFeed(Long feedId, UpdateFeedRequest request) {
        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(RuntimeException::new);

        feed.modifyFeed(request.getTitle(), request.getContent());
    }

}
