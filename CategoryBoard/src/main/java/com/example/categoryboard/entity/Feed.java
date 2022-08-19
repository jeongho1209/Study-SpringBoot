package com.example.categoryboard.entity;

import com.example.categoryboard.type.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Builder
    public Feed(String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public void modifyFeed(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
