//package com.example.springaad.config;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.OAuth2Error;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.security.web.server.authentication.RedirectServerAuthenticationEntryPoint;
//
//import java.util.Map;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
////                .csrf().ignoringRequestMatchers("/oauth2/**")
////                .and()
//                .authorizeHttpRequests( authorize -> authorize
//                        .requestMatchers("/outh2/**", "/login/**").permitAll()
//                        .requestMatchers("/").permitAll()
////                        .anyRequest().authenticated()
//                    )
////                .oauth2Login()
////                    .loginPage("/login")
////                    .userInfoEndpoint()
////                        .userService(userService())
////                        .and()
////                    .defaultSuccessUrl("/")
////                    .and()
////                .logout()
////                    .logoutSuccessUrl("/")
////                    .and()
//                .build();
//
//    }
//
//}
