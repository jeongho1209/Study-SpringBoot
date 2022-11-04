package com.example.fcm.infrastructure.feign.config;

import com.example.fcm.infrastructure.feign.error.FeignClientErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.example.fcm.infrastructure.feign")
@Configuration
public class FeignConfig {

    @Bean
    @ConditionalOnMissingBean(value = ErrorDecoder.class)
    public FeignClientErrorDecoder feignErrorDecoder() {
        return new FeignClientErrorDecoder();
    }

}
