package com.example.studyspringboot.domain.user.domain;

import com.example.studyspringboot.domain.user.domain.type.Sex;
import com.example.studyspringboot.global.enums.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 64)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 20)
    @Column(unique = true)
    private String accountId;

    @NotNull
    @Size(max = 60)
    private String password;

    @NotNull
    @Size(max = 10)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @Size(max = 50)
    private String introduce;

    @Builder
    public User(String email, String accountId, String password, String name, Sex sex, Role role, String introduce) {
        this.email = email;
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.role = role;
        this.introduce = introduce;
    }

    public void modifyInfo(String introduce, String name) {
        this.introduce = introduce;
        this.name = name;
    }

}
