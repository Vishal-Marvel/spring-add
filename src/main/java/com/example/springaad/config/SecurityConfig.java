package com.example.springaad.config;

import com.azure.spring.cloud.autoconfigure.implementation.aad.security.AadWebApplicationHttpSecurityConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService;

    public SecurityConfig(OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService) {
        this.oidcUserService = oidcUserService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests( authorize -> authorize
                        .requestMatchers("/outh2/**", "/login/**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .oidcUserService(oidcUserService)
                .and()
                .and()
                .build();
//        httpSecurity.apply(AadWebApplicationHttpSecurityConfigurer.aadWebApplication())
//                .and()
//                .authorizeHttpRequests()
//                .
//                .anyRequest().authenticated();
//        return httpSecurity.build();
    }
}
