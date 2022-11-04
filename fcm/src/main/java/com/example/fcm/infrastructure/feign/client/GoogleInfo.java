package com.example.fcm.infrastructure.feign.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "GoogleInfoClient", url = "https://www.googleapis.com/oauth2/v1/userinfo")
public interface GoogleInfo {
}
