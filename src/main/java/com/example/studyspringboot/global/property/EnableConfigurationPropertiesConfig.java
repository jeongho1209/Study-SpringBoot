package com.example.studyspringboot.global.property;

import com.example.studyspringboot.global.security.jwt.JwtProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = {JwtProperty.class})
@Configuration
public class EnableConfigurationPropertiesConfig {
}
