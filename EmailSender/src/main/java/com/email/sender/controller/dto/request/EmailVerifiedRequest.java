package com.email.sender.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class EmailVerifiedRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String code;

}
