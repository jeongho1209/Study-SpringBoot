package com.example.studyspringboot.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class FeedListResponse {

    private final List<FeedResponse> feedList;

    @Getter
    @Builder
    public static class FeedResponse {
        private final Long feedId;
        private final Integer views;
        private final String title;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;
        private final String name;
    }

}
