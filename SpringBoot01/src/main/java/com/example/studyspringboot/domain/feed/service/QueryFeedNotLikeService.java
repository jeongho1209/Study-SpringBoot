package com.example.studyspringboot.domain.feed.service;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.feed.domain.repository.FeedRepository;
import com.example.studyspringboot.domain.feed.presentation.dto.response.FeedListResponse;
import com.example.studyspringboot.domain.feed.presentation.dto.response.FeedListResponse.FeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryFeedNotLikeService {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public FeedListResponse execute() {
        return new FeedListResponse(
                feedRepository.queryFeedNotLike()
                        .stream()
                        .map(this::buildFeedList)
                        .collect(Collectors.toList())
        );
    }

    private FeedResponse buildFeedList(Feed feed) {
        return FeedResponse.builder()
                .feedId(feed.getId())
                .title(feed.getTitle())
                .views(feed.getViews())
                .createdAt(feed.getCreatedAt())
                .updatedAt(feed.getUpdatedAt())
                .likeCounts(feed.getLikeCounts())
                .unLikeCounts(feed.getUnLikeCounts())
                .name(feed.getUser().getName())
                .build();
    }

}
