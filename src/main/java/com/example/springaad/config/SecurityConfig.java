package com.example.springaad.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationEntryPoint;

import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final ApplicationEventPublisher eventPublisher;
    private final ApplicationContext applicationContext;


    public SecurityConfig(ApplicationEventPublisher eventPublisher, ApplicationContext applicationContext) {
        this.eventPublisher = eventPublisher;
        this.applicationContext = applicationContext;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
//                .csrf().ignoringRequestMatchers("/oauth2/**")
//                .and()
                .authorizeHttpRequests( authorize -> authorize
                        .requestMatchers("/outh2/**", "/login/**").permitAll()
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
                    )
                .oauth2Login()
//                    .loginPage("/login")
                    .userInfoEndpoint()
//                        .userService(userService())
                        .and()
                    .defaultSuccessUrl("/")
                    .and()
//                .logout()
//                    .logoutSuccessUrl("/")
//                    .and()
                .build();

    }
//    @Bean
//    public OAuth2UserService<OAuth2UserRequest, OAuth2User> userService() {
//        return new CustomOAuth2UserService();
//    }
//    @Bean
//    public AuthenticationFailureHandler authenticationFailureHandler() {
//        return new SimpleUrlAuthenticationFailureHandler("/login?error");
//    }

//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        return new InMemoryClientRegistrationRepository(
//                ClientRegistration.withRegistrationId("azure")
//                        .clientId("56373f78-a985-440f-bdfb-bc45a0b82ba9")
//                        .clientSecret("Rxg8Q~VMXbwUQY7DIkGJad2n8BAixtIQh6La_chD")
//                        .clientName("Azure AD")
//                        .redirectUri("http://localhost:8080/login/oauth2/code/")
//                        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                        .scope("openid", "profile", "email")
//                        .authorizationUri("https://login.microsoftonline.com/a01dffac-c22e-45ba-b531-fcdf22abd834/oauth2/v2.0/authorize")
//                        .tokenUri("https://login.microsoftonline.com/a01dffac-c22e-45ba-b531-fcdf22abd834/oauth2/v2.0/token")
//                        .userInfoUri("https://graph.microsoft.com/v1.0/me")
//                        .userNameAttributeName("displayName")
//                        .build()
//        );
//    }
//    private ApplicationEventPublisher eventPublisher() {
//        return applicationContext.getBean(ApplicationEventPublisher.class);
//    }
}
