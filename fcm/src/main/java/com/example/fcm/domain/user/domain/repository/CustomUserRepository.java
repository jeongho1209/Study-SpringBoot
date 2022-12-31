package com.example.fcm.domain.user.domain.repository;

import com.example.fcm.domain.user.domain.User;

import java.util.List;

public interface CustomUserRepository {

    List<User> queryUserPaging();

}
