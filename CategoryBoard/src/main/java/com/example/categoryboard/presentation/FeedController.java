package com.example.categoryboard.presentation;

import com.example.categoryboard.presentation.dto.request.CreateFeedRequest;
import com.example.categoryboard.presentation.dto.request.UpdateFeedRequest;
import com.example.categoryboard.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final FeedService feedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        feedService.createFeed(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Long feedId) {
        feedService.deleteFeed(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{feed-id}")
    public void modifyFeed(@PathVariable("feed-id") Long feedId,
                           UpdateFeedRequest request) {
        feedService.modifyFeed(feedId, request);
    }

}
