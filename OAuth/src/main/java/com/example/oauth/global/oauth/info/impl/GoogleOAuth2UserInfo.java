package com.example.oauth.global.oauth.info.impl;

import com.example.oauth.global.oauth.info.OAuth2UserInfo;

import java.util.Map;

public class GoogleOAuth2UserInfo extends OAuth2UserInfo {

    public GoogleOAuth2UserInfo(Map<String, Object> attributes, String nameAttributeKey, String name, String email) {
        super(attributes, nameAttributeKey, name, email);
    }

    public static OAuth2UserInfo ofGoogle(Map<String, Object> attributes) {
        return GoogleOAuth2UserInfo.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey("sub")
                .build();
    }

}

