package com.example.studyspringboot.domain.user.service;

import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.domain.repository.UserRepository;
import com.example.studyspringboot.domain.user.exception.UserNotFoundException;
import com.example.studyspringboot.domain.user.presentation.dto.request.QueryAnotherUserInfoRequest;
import com.example.studyspringboot.domain.user.presentation.dto.response.QueryMyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryAnotherUserInfoService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public QueryMyInfoResponse userInfo(QueryAnotherUserInfoRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return QueryMyInfoResponse.builder()
                .introduce(user.getIntroduce())
                .sex(user.getSex())
                .name(user.getName())
                .build();
    }

}
