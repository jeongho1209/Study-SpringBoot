package com.example.categoryboard.service;

import com.example.categoryboard.entity.Feed;
import com.example.categoryboard.presentation.dto.request.UpdateFeedRequest;
import com.example.categoryboard.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void modifyFeed(Long feedId, UpdateFeedRequest request) {
        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(RuntimeException::new);

        feed.modifyFeed(request.getTitle(), request.getContent());
    }

}
