package com.email.sender.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String accountId;

    @Column(length = 64, nullable = false, unique = true)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @Size(max = 50)
    private String introduce;

    @Builder
    public User(String accountId, String email, String password, String name, String introduce) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.introduce = introduce;
    }

    public void modifyInfo(String name, String introduce) {
        this.name = name;
        this.introduce = introduce;
    }

    public void changePassword(String password) {
        this.password = password;
    }

}
