package com.example.oauth.domain.user.domain;

import com.example.oauth.domain.user.domain.type.ProviderType;
import com.example.oauth.domain.user.domain.type.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false, unique = true)
    private String email;

    @Column(length = 10, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProviderType providerType;

    @Builder
    public User(String email, String name, ProviderType providerType, Role role) {
        this.email = email;
        this.name = name;
        this.providerType = providerType;
        this.role = role;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role.getRole();
    }

}