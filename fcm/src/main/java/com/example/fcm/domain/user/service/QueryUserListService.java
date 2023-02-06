package com.example.fcm.domain.user.service;

import com.example.fcm.domain.user.domain.repository.UserRepository;
import com.example.fcm.domain.user.presentation.dto.response.QueryUserElement;
import com.example.fcm.domain.user.presentation.dto.response.QueryUserListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryUserListService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public QueryUserListResponse execute() {
        return new QueryUserListResponse(
                userRepository.queryUserPaging()
                        .stream()
                        .map(QueryUserElement::of)
                        .collect(Collectors.toList())
        );
    }
}
