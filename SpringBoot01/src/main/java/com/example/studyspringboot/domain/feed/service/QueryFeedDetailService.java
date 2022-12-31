package com.example.studyspringboot.domain.feed.service;

import com.example.studyspringboot.domain.comment.domain.repository.CommentRepository;
import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.feed.facade.FeedFacade;
import com.example.studyspringboot.domain.feed.presentation.dto.response.FeedDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryFeedDetailService {

    private final FeedFacade feedFacade;

    @Transactional
    public FeedDetailResponse getFeedDetail(Integer feedId) {
        Feed feed = feedFacade.getFeed(feedId);

        feed.addViews();

        return FeedDetailResponse.builder()
                .feedId(feed.getId())
                .title(feed.getTitle())
                .content(feed.getContent())
                .createdAt(feed.getCreatedAt())
                .updatedAt(feed.getUpdatedAt())
                .likeCounts(feed.getLikeCounts())
                .unLikeCounts(feed.getUnLikeCounts())
                .views(feed.getViews())
                .name(feed.getUser().getName())
                .build();
    }

}
