package com.example.querydsl.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberDto {

    private String userName;
    private int age;

    public MemberDto(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

}
