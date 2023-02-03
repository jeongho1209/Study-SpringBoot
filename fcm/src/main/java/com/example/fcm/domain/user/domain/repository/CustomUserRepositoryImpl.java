package com.example.fcm.domain.user.domain.repository;

import com.example.fcm.domain.user.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.fcm.domain.user.domain.QUser.user;

@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<User> queryUserPaging() {
        return queryFactory
                .selectFrom(user)
                .orderBy(user.id.desc())
                .fetch();
    }
}
