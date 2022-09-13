package com.example.studyspringboot.domain.feed.domain.repository;

import com.example.studyspringboot.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepository extends CrudRepository<Feed, Integer> {

    @Query("select f from Feed f join fetch f.user order by f.createdAt DESC ")
    List<Feed> findAllByJoinFetch();

    List<Feed> findAllByTitleContaining(String title);

}
