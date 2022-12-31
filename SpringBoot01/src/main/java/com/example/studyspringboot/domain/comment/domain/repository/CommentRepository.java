package com.example.studyspringboot.domain.comment.domain.repository;

import com.example.studyspringboot.domain.comment.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
