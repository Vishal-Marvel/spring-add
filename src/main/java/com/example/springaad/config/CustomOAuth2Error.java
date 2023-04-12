package com.example.springaad.config;

import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;

public class CustomOAuth2Error extends OAuth2Error implements OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> {

    private static final long serialVersionUID = 1L;

    public CustomOAuth2Error(OAuth2Error oAuth2Error) {
        super(oAuth2Error.getErrorCode(), oAuth2Error.getDescription(), oAuth2Error.getUri());
    }

    @Override
    public OAuth2AccessTokenResponse getTokenResponse(OAuth2AuthorizationCodeGrantRequest authorizationGrantRequest) {
        return null;
    }
}
