package com.example.categoryboard.presentation;

import com.example.categoryboard.presentation.dto.request.CreateFeedRequest;
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

}
