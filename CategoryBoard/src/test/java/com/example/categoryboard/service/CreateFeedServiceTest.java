package com.example.categoryboard.service;

import com.example.categoryboard.domain.feed.domain.Feed;
import com.example.categoryboard.domain.feed.domain.type.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateFeedServiceTest {

    @Test
    @DisplayName("게시글 생성 테스트")
    void createFeed() {

        // given
        String title = "제목";
        String content = "내용";
        Category category = Category.valueOf("Answer");

        // when
        Feed feed = Feed.builder()
                .title(title)
                .content(content)
                .category(category)
                .build();

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(title, feed.getTitle()),
                () -> Assertions.assertEquals(content, feed.getContent()),
                () -> Assertions.assertEquals(category, feed.getCategory())
        );
    }

}