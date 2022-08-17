package com.example.studyspringboot.domain.user.domain.repository;

import com.example.studyspringboot.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
