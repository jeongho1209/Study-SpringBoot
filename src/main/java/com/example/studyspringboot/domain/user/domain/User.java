package com.example.studyspringboot.domain.user.domain;

import com.example.studyspringboot.domain.user.domain.type.Sex;
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
    private String accountId;

    @NotNull
    @Size(max = 60)
    private String password;

    @NotNull
    @Size(max = 8)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Size(max = 50)
    private String introduce;

    @Builder
    public User(String email, String accountId, String password, String name, Sex sex, String introduce) {
        this.email = email;
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.introduce = introduce;
    }

    public void modifyInfo(String introduce) {
        this.introduce = introduce;
    }

}
