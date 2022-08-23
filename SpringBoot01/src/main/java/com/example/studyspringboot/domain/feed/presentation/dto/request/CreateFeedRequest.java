package com.example.studyspringboot.domain.feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateFeedRequest {

    @NotNull(message = "title은 Null이 불가합니다.")
    @Size(max = 20, message = "title은 최대 20자입니다.")
    private String title;

    @NotNull(message = "content는 Null이 불가합니다.")
    @Size(max = 500, message = "content는 최대 500자입니다.")
    private String content;

}
