package com.example.studyspringboot.domain.comment.domain;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseTimeIdEntity {

    @NotNull
    @Size(max = 250)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Comment(String comment, Feed feed, User user) {
        this.comment = comment;
        this.feed = feed;
        this.user = user;
    }

    public void modifyComment(String comment) {
        this.comment = comment;
    }

}
