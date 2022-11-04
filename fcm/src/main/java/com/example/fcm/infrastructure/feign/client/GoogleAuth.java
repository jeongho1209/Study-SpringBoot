package com.example.fcm.infrastructure.feign.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "GoogleAuthClient", url = "https://oauth2.googleapis.com/token")
public interface GoogleAuth {
}
