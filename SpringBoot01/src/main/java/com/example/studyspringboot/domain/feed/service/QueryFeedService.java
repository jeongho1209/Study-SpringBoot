package com.example.studyspringboot.domain.feed.service;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.feed.domain.repository.FeedRepository;
import com.example.studyspringboot.domain.feed.presentation.dto.response.FeedListResponse;
import com.example.studyspringboot.domain.feed.presentation.dto.response.FeedListResponse.FeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryFeedService {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public FeedListResponse getFeedList() {
        List<FeedResponse> feedList = feedRepository.findAllByJoinFetch()
                .stream()
                .map(this::buildFeedList)
                .collect(Collectors.toList());

        return new FeedListResponse(feedList);
    }

    private FeedResponse buildFeedList(Feed feed) {
        return FeedResponse.builder()
                .feedId(feed.getId())
                .title(feed.getTitle())
                .views(feed.getViews())
                .createdAt(feed.getCreatedAt())
                .updatedAt(feed.getUpdatedAt())
                .name(feed.getUser().getName())
                .build();
    }

}
