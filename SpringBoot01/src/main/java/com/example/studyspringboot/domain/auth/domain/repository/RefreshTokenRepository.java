package com.example.studyspringboot.domain.auth.domain.repository;

import com.example.studyspringboot.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
