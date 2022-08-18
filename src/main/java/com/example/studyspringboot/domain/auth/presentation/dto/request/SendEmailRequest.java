package com.example.studyspringboot.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SendEmailRequest {

    @Email
    @NotBlank(message = "email은 Null, 공백, 띄어쓰기를 허용하지 않고 이메일 형식을 지켜야 합니다.")
    private String email;

}
