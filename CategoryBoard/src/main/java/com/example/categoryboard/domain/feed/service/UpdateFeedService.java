package com.example.categoryboard.domain.feed.service;

import com.example.categoryboard.domain.feed.domain.Feed;
import com.example.categoryboard.domain.feed.domain.repository.FeedRepository;
import com.example.categoryboard.domain.feed.presentation.dto.request.UpdateFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void modifyFeed(Integer feedId, UpdateFeedRequest request) {
        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(RuntimeException::new);

        feed.modifyFeed(request.getTitle(), request.getContent());
    }

}
