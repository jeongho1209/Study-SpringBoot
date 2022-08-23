package com.example.studyspringboot.domain.feed.presentation;

import com.example.studyspringboot.domain.feed.presentation.dto.response.FeedListResponse;
import com.example.studyspringboot.domain.feed.service.QueryFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final QueryFeedService queryFeedService;

    @GetMapping("/list")
    public FeedListResponse getFeedList() {
        return queryFeedService.getFeedList();
    }

}
