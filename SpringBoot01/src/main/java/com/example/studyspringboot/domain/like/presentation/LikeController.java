package com.example.studyspringboot.domain.like.presentation;

import com.example.studyspringboot.domain.like.presentation.dto.response.LikeResponse;
import com.example.studyspringboot.domain.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/like")
@RestController
public class LikeController {

    private final LikeService likeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public LikeResponse liked(@PathVariable("feed-id") Long feedId) {
        return likeService.liked(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public LikeResponse deleteLiked(@PathVariable("feed-id") Long feedId) {
        return likeService.deleteLiked(feedId);
    }

}
