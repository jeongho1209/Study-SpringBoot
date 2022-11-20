package com.example.studyspringboot.domain.user.service;

import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.facade.UserFacade;
import com.example.studyspringboot.domain.user.presentation.dto.request.QueryAnotherUserInfoRequest;
import com.example.studyspringboot.domain.user.presentation.dto.response.QueryUserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryAnotherUserInfoService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryUserInfoResponse execute(QueryAnotherUserInfoRequest request) {
        User user = userFacade.getUserById(request.getUserId());

        return QueryUserInfoResponse.builder()
                .introduce(user.getIntroduce())
                .sex(user.getSex())
                .name(user.getName())
                .build();
    }

}
