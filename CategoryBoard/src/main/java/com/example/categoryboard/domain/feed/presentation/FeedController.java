package com.example.categoryboard.domain.feed.presentation;

import com.example.categoryboard.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.categoryboard.domain.feed.presentation.dto.request.UpdateFeedRequest;
import com.example.categoryboard.domain.feed.service.CreateFeedService;
import com.example.categoryboard.domain.feed.service.DeleteFeedService;
import com.example.categoryboard.domain.feed.service.UpdateFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;
    private final UpdateFeedService updateFeedService;
    private final DeleteFeedService deleteFeedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        createFeedService.createFeed(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Integer feedId) {
        deleteFeedService.deleteFeed(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{feed-id}")
    public void modifyFeed(@PathVariable("feed-id") Integer feedId,
                           UpdateFeedRequest request) {
        updateFeedService.modifyFeed(feedId, request);
    }

}
