package com.example.studyspringboot.domain.user.domain.repository;

import com.example.studyspringboot.domain.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByAccountId(String accountId);

    Optional<User> findByEmail(String email);

    List<User> queryUserByFollowCountsLessThan(Integer key);

}
