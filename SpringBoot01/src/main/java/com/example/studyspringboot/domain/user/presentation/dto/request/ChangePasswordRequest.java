package com.example.studyspringboot.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class ChangePasswordRequest {

    @NotBlank
    private String oldPassword;

    @NotBlank
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;<=>?@＼^_`{|}~]{8,60}$",
            message = "password는 Null, 공백, 띄어쓰기를 허용하지 않고, 영문, 숫자, 특수기호가 포함되어야 하며 8글자 이상 60글자 이하여야 합니다.")
    private String newPassword;

}
