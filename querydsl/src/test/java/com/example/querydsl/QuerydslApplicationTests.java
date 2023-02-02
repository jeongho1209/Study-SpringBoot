package com.example.querydsl;

import com.example.querydsl.domain.dto.MemberDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.querydsl.domain.entity.QMember.member;

@SpringBootTest
class QuerydslApplicationTests {

    @Autowired
    EntityManager em;

    JPAQueryFactory jpaQueryFactory;

    @Test
    void contextLoads() {
    }

    @Test
    void simpleProject() {
        List<MemberDto> result = jpaQueryFactory
                .select(Projections.bean(MemberDto.class, member.username, member.age))
                .from(member)
                .fetch();

        for (MemberDto memberDto : result) {
            System.out.println(memberDto);
        }

    }
}
