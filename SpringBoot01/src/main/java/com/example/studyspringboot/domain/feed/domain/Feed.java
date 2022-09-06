package com.example.studyspringboot.domain.feed.domain;

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
public class Feed extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    private String title;

    @NotNull
    @Size(max = 500)
    private String content;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedAt;

    @NotNull
    private Integer views;

    @NotNull
    private Integer likeCounts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Feed(String title, String content, LocalDateTime updatedAt, Integer views, Integer likeCounts, User user) {
        this.title = title;
        this.content = content;
        this.updatedAt = updatedAt;
        this.views = views;
        this.likeCounts = likeCounts;
        this.user = user;
    }

    public void modifyFeed(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addViews() {
        this.views += 1;
    }

    public void addLikeCount() {
        this.likeCounts += 1;
    }

    public void minusLikeCount() {
        this.likeCounts -= 1;
    }

}
