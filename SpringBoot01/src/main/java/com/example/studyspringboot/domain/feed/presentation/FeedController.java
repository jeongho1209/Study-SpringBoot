package com.example.studyspringboot.domain.feed.presentation;

import com.example.studyspringboot.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.studyspringboot.domain.feed.presentation.dto.request.UpdateFeedRequest;
import com.example.studyspringboot.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.example.studyspringboot.domain.feed.presentation.dto.response.FeedListResponse;
import com.example.studyspringboot.domain.feed.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;
    private final QueryFeedService queryFeedService;
    private final SearchFeedService searchFeedService;
    private final QueryFeedDetailService queryFeedDetailService;
    private final QueryFeedNotLikeService queryFeedNotLikeService;
    private final UpdateFeedService updateFeedService;
    private final DeleteFeedService deleteFeedService;
    private final QueryFeedTestService queryFeedTestService;

    @GetMapping("/list")
    public FeedListResponse getFeedList() {
        return queryFeedService.getFeedList();
    }

    @GetMapping("/{feed-id}")
    public FeedDetailResponse getFeedDetail(@PathVariable("feed-id") Integer feedId) {
        return queryFeedDetailService.getFeedDetail(feedId);
    }

    @GetMapping("/search/{title}")
    public FeedListResponse searchFeed(@PathVariable("title") String title) {
        return searchFeedService.searchFeed(title);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        createFeedService.createFeed(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{feed-id}")
    public void modifyFeed(@PathVariable("feed-id") Integer feedId,
                           @RequestBody @Valid UpdateFeedRequest request) {
        updateFeedService.execute(feedId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Integer feedId) {
        deleteFeedService.execute(feedId);
    }

    @GetMapping("/all")
    public FeedListResponse queryList() {
        return queryFeedNotLikeService.execute();
    }

    @GetMapping("/test")
    public FeedListResponse test(@RequestParam(value = "created_at", required = false)
                                 @DateTimeFormat(pattern = "yyyy-MM-dd")
                                 LocalDate createdAt) {
        return queryFeedTestService.execute(createdAt);
    }

}
