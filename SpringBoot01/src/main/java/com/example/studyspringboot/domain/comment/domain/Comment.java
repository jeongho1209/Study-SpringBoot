package com.example.studyspringboot.domain.comment.domain;

import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 250)
    private String comment;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Comment(String comment, LocalDateTime updatedAt, Feed feed, User user) {
        this.comment = comment;
        this.updatedAt = updatedAt;
        this.feed = feed;
        this.user = user;
    }

    public void modifyComment(String comment) {
        this.comment = comment;
    }

}
