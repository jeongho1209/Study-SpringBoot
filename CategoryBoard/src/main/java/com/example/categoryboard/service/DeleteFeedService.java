package com.example.categoryboard.service;

import com.example.categoryboard.entity.Feed;
import com.example.categoryboard.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void deleteFeed(Long feedId) {
        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(RuntimeException::new);

        feedRepository.delete(feed);
    }

}
