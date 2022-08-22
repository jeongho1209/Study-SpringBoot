package com.example.studyspringboot.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {

    @NotBlank(message = "name은 공백, Null이 불가합니다.")
    @Size(min = 1, max = 10, message = "name은 1자 이상 10자 이하여야 합니다.")
    private String name;

    @Size(max = 300, message = "introduce는 300자 이하여야 합니다.")
    private String introduce;

}
