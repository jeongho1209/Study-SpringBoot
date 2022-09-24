package com.example.categoryboard.domain.feed.domain.repository;

import com.example.categoryboard.domain.feed.domain.Feed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends CrudRepository<Feed, Integer> {
}
