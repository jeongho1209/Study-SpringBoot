package com.example.fcm.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserSignInRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
