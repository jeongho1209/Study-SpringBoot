package com.example.studyspringboot.domain.user.service;

import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.facade.UserFacade;
import com.example.studyspringboot.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateUserInfoService {

    private final UserFacade userFacade;

    @Transactional
    public void modifyInfo(UpdateUserInfoRequest request) {
        User user = userFacade.getCurrentUser();

        user.modifyInfo(request.getIntroduce(),
                request.getName());
    }

}
