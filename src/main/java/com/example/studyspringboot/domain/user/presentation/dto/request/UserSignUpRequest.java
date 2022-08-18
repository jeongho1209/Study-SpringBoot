package com.example.studyspringboot.domain.user.presentation.dto.request;

import com.example.studyspringboot.domain.user.domain.type.Sex;
import com.example.studyspringboot.global.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @NotBlank
    @Size(min = 8, max = 20, message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않으며, 8자 이상 20자 이하여야합니다.")
    private String accountId;

    @NotBlank
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;<=>?@＼^_`{|}~]{8,60}$",
            message = "password는 Null, 공백, 띄어쓰기를 허용하지 않고, 영문, 숫자, 특수기호가 포함되어야 하며 8글자 이상 60글자 이하여야 합니다.")
    private String password;

    @Email(message = "올바른 email형식을 지켜주세요")
    @NotBlank(message = "email는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(max = 64, message = "email은 64자 이하여야 합니다.")
    private String email;

    @NotBlank
    @Size(min = 1, max = 10, message = "name은 Null, 공백, 띄어쓰기를 허용하지 않으며, 1자 이상 10자 이하여야 합니다.")
    private String name;

    @NotNull(message = "sex는 Null을 허용하지 않습니다.")
    private Sex sex;

    @NotNull(message = "Role은 Null을 허용하지 않습니다.")
    private Role role;

}
