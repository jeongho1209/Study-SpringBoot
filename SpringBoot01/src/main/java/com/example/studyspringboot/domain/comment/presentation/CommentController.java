package com.example.studyspringboot.domain.comment.presentation;

import com.example.studyspringboot.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.studyspringboot.domain.comment.service.CreateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {

    private final CreateCommentService createCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public void createComment(@PathVariable("feed-id") Integer feedId,
                              @RequestBody @Valid CreateCommentRequest request) {
        createCommentService.execute(feedId, request);
    }

}
