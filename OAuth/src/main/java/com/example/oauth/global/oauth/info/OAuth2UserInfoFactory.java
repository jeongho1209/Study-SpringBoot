package com.example.oauth.global.oauth.info;

import com.example.oauth.domain.user.domain.type.ProviderType;
import com.example.oauth.global.oauth.exception.InvalidProviderTypeException;
import com.example.oauth.global.oauth.info.impl.GoogleOAuth2UserInfo;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(ProviderType providerType, Map<String, Object> attributes) {

        if (providerType != ProviderType.GOOGLE) {
            throw InvalidProviderTypeException.EXCEPTION;
        }

        return GoogleOAuth2UserInfo.ofGoogle(attributes);
    }

}
