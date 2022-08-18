package com.example.studyspringboot.domain.auth.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@RedisHash
public class Certification implements Serializable {

    @Id
    @Indexed
    private String email;

    @TimeToLive
    private Integer codeExp;

    private String code;
    private boolean isVerify;

    public Certification updateCode(String code) {
        this.code = code;
        return this;
    }

    public Certification updateCertified(boolean isVerify) {
        this.isVerify = true;
        return this;
    }

}
