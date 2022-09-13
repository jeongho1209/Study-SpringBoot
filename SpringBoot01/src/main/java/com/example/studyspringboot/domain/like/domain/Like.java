package com.example.studyspringboot.domain.like.domain;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_feed_like")
public class Like extends BaseIdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Like(Feed feed, User user) {
        this.feed = feed;
        this.user = user;
    }

}
