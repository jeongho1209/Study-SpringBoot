package com.example.studyspringboot.domain.feed.domain.repository;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import static com.example.studyspringboot.domain.feed.domain.QFeed.feed;
import static com.example.studyspringboot.domain.like.domain.QLike.like;

@RequiredArgsConstructor
public class FeedRepositoryCustomImpl implements FeedRepositoryCustom {

    private final JPAQueryFactory query;

    @Override
    public List<Feed> queryFeedNotLike() {
        return query
                .selectFrom(feed)
                .leftJoin(like)
                .on(feed.id.eq(like.feed.id))
                .where(like.id.eq(1))
                .fetch();
    }

    @Override
    public List<Feed> queryFeedViews(LocalDate createdAt) {
        return query
                .selectFrom(feed)
                .where(feed.createdAt.gt(createdAt))
                .fetch();
    }

}
