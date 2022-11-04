package com.example.fcm.infrastructure.feign.client;

import com.example.fcm.infrastructure.feign.dto.response.GoogleInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "GoogleInfoClient", url = "https://www.googleapis.com/oauth2/v1/userinfo")
public interface GoogleInfo {

    @GetMapping("?alt=json&access_token={ACCESS_TOKEN}")
    GoogleInfoResponse googleInfo(@PathVariable("ACCESS_TOKEN") String accessToken);

}
