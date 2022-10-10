package com.example.studyspringboot.domain.feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateFeedRequest {

    @NotBlank
    @Size(max = 20)
    private String title;

    @NotBlank
    @Size(max = 500)
    private String content;

}
