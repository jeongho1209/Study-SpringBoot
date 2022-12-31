package com.example.studyspringboot.domain.comment.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentElement {

    private final String comment;
    private final LocalDateTime updatedAt;
    private final String name;

}
