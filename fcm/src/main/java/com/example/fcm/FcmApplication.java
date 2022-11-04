package com.example.fcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FcmApplication {

    public static void main(String[] args) {
        SpringApplication.run(FcmApplication.class, args);
    }

}
