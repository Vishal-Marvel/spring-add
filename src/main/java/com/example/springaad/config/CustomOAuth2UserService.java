package com.example.springaad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collections;

public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // TODO: Handle user information returned by Azure AD
        // You can use the userRequest parameter to get the access token, ID token, etc.
        // You can also use the OAuth2User class to get user attributes such as email, name, etc.

        return new DefaultOAuth2User(Collections.emptySet(), Collections.emptyMap(), "");
    }
    @Bean
    public CustomOAuth2UserService customOAuth2UserService() {
        return new CustomOAuth2UserService();
    }

}
