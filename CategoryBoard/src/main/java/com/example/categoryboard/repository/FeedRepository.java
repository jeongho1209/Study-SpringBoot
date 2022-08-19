package com.example.categoryboard.repository;

import com.example.categoryboard.entity.Feed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends CrudRepository<Feed, Long> {
}
