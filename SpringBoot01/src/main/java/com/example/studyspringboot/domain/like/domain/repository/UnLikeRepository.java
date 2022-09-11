package com.example.studyspringboot.domain.like.domain.repository;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.like.domain.Like;
import com.example.studyspringboot.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UnLikeRepository extends CrudRepository<Like, Integer> {

    boolean existsByUserAndFeed(User user, Feed feed);

    void deleteByUserAndFeed(User user, Feed feed);
}
