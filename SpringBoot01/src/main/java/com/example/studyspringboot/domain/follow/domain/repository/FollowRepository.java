package com.example.studyspringboot.domain.follow.domain.repository;

import com.example.studyspringboot.domain.follow.domain.Follow;
import com.example.studyspringboot.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends CrudRepository<Follow, Integer> {

    boolean existsByUserAndTargetUser(User currentUser, User targetUser);

}
