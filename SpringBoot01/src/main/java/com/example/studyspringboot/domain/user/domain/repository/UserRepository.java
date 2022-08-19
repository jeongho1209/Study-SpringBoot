package com.example.studyspringboot.domain.user.domain.repository;

import com.example.studyspringboot.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);

    Optional<User> findByEmail(String email);

}
