package com.example.studyspringboot.domain.comment.service;

import com.example.studyspringboot.domain.comment.domain.Comment;
import com.example.studyspringboot.domain.comment.domain.repository.CommentRepository;
import com.example.studyspringboot.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.studyspringboot.domain.feed.domain.Feed;
import com.example.studyspringboot.domain.feed.facade.FeedFacade;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateCommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void execute(Integer feedId, CreateCommentRequest request) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(feedId);

        commentRepository.save(Comment.builder()
                .comment(request.getComment())
                .feed(feed)
                .user(user)
                .build());
    }

}
