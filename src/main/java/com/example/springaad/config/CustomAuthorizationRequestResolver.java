package com.example.springaad.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.OAuth2AuthorizationException;
import org.springframework.security.oauth2.core.OAuth2Error;

import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;

//@Component
public class CustomAuthorizationRequestResolver implements OAuth2AuthorizationRequestResolver {

    private final OAuth2AuthorizationRequestResolver defaultResolver;
    private final ApplicationEventPublisher eventPublisher;

    public CustomAuthorizationRequestResolver(
            ClientRegistrationRepository clientRegistrationRepository,
            ApplicationEventPublisher eventPublisher) {
        this.defaultResolver = new DefaultOAuth2AuthorizationRequestResolver(
                clientRegistrationRepository, OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI);
        this.eventPublisher = eventPublisher;
    }

    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request) {
        try {
            return defaultResolver.resolve(request);
        } catch (OAuth2AuthorizationException ex) {
            OAuth2Error error = ex.getError();

            throw ex;
        }
    }

    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request, String clientRegistrationId) {
        try {
            return defaultResolver.resolve(request, clientRegistrationId);
        } catch (OAuth2AuthorizationException ex) {
            OAuth2Error error = ex.getError();
            throw ex;
        }
    }

}
