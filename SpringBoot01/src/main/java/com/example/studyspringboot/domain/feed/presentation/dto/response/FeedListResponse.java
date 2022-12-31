package com.example.studyspringboot.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class FeedListResponse {

    private final List<FeedResponse> feedList;

    @Getter
    @Builder
    public static class FeedResponse {
        private final Integer feedId;
        private final Integer views;
        private final String title;
        private final LocalDate createdAt;
        private final LocalDate updatedAt;
        private final Integer likeCounts;
        private final Integer unLikeCounts;
        private final String name;
    }

}
