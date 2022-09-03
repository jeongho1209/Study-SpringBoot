package com.example.studyspringboot.domain.feed.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FeedDetailResponse {

    private Long feedId;
    private String title;
    private String content;
    private Integer views;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String name;

}
