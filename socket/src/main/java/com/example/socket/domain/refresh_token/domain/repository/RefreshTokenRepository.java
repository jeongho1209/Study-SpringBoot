package com.example.socket.domain.refresh_token.domain.repository;

import com.example.socket.domain.refresh_token.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
