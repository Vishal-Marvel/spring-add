package com.example.springaad.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
//                .csrf().ignoringRequestMatchers("/oauth2/**")
//                .and()
                .authorizeHttpRequests( authorize -> authorize
                        .requestMatchers("/outh2/**", "/login/**").permitAll()
                        .requestMatchers("/").authenticated()
                        .anyRequest().permitAll()
                    )
                .oauth2Login()
                    .loginPage("/login")
//                    .userInfoEndpoint()
//                        .userService(userService())
//                        .and()
                    .defaultSuccessUrl("/")
                    .and()
//                .logout()
//                    .logoutSuccessUrl("/")
//                    .and()
                .build();

    }

}
