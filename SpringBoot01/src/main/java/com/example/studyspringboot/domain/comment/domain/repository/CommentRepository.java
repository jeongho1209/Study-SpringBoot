package com.example.studyspringboot.domain.comment.domain.repository;

import com.example.studyspringboot.domain.comment.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
