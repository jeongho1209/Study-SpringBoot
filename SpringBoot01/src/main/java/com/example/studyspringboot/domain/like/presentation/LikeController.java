package com.example.studyspringboot.domain.like.presentation;

import com.example.studyspringboot.domain.like.presentation.dto.response.LikeResponse;
import com.example.studyspringboot.domain.like.presentation.dto.response.UnLikeResponse;
import com.example.studyspringboot.domain.like.service.LikeService;
import com.example.studyspringboot.domain.like.service.UnLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/like")
@RestController
public class LikeController {

    private final LikeService likeService;
    private final UnLikeService unLikeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public LikeResponse liked(@PathVariable("feed-id") Integer feedId) {
        return likeService.liked(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public LikeResponse deleteLiked(@PathVariable("feed-id") Integer feedId) {
        return likeService.deleteLiked(feedId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/unlike/{feed-id}")
    public UnLikeResponse unLiked(@PathVariable("feed-id") Integer feedId) {
        return unLikeService.unLiked(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/unlike/{feed-id}")
    public UnLikeResponse deleteUnLiked(@PathVariable("feed-id") Integer feedId) {
        return unLikeService.deleteUnLiked(feedId);
    }

}
