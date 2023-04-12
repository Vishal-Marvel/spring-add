package com.example.springaad.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class OAuth2AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof OAuth2AuthenticationException) {
            OAuth2AuthenticationException oauthException = (OAuth2AuthenticationException) exception;
            OAuth2Error oauthError = oauthException.getError();

            // handle the OAuth2 error
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
