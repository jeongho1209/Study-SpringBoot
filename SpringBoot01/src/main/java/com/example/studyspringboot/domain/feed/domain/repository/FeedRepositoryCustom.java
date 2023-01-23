package com.example.studyspringboot.domain.feed.domain.repository;

import com.example.studyspringboot.domain.feed.domain.Feed;

import java.time.LocalDate;
import java.util.List;

public interface FeedRepositoryCustom {

    List<Feed> queryFeedNotLike();

    List<Feed> queryFeedViews(LocalDate createdAt);

}
