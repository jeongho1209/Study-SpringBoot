package com.example.fcm.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Length(max = 20)
    private String accountId;

    @NotNull
    @Length(max = 60)
    private String password;

    @NotNull
    @Length(max = 10)
    private String name;

    @Builder
    public User(String accountId, String password, String name) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
    }

}
