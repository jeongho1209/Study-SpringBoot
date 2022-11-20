package com.example.studyspringboot.domain.user.service;

import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.facade.UserFacade;
import com.example.studyspringboot.domain.user.presentation.dto.response.QueryUserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMyInfoService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryUserInfoResponse getMyInfo() {
        User user = userFacade.getCurrentUser();

        return QueryUserInfoResponse.builder()
                .name(user.getName())
                .sex(user.getSex())
                .introduce(user.getIntroduce())
                .build();
    }

}
