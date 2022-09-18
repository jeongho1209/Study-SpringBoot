package com.example.studyspringboot.domain.comment.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateCommentRequest {

    @NotBlank
    @Size(max = 250)
    private String comment;

}
