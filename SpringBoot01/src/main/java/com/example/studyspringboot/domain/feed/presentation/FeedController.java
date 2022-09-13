package com.example.studyspringboot.domain.feed.presentation;

import com.example.studyspringboot.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.studyspringboot.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.example.studyspringboot.domain.feed.presentation.dto.response.FeedListResponse;
import com.example.studyspringboot.domain.feed.service.CreateFeedService;
import com.example.studyspringboot.domain.feed.service.QueryFeedDetailService;
import com.example.studyspringboot.domain.feed.service.QueryFeedService;
import com.example.studyspringboot.domain.feed.service.SearchFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;
    private final QueryFeedService queryFeedService;
    private final SearchFeedService searchFeedService;
    private final QueryFeedDetailService queryFeedDetailService;

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

}
