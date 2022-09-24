package com.example.categoryboard.domain.feed.service;

import com.example.categoryboard.domain.feed.domain.Feed;
import com.example.categoryboard.domain.feed.domain.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void deleteFeed(Integer feedId) {
        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(RuntimeException::new);

        feedRepository.delete(feed);
    }

}
