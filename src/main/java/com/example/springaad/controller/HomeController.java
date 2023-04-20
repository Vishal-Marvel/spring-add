package com.example.springaad.controller;

import com.example.springaad.config.JWTSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final JWTSecurity jwtSecurity;

    @GetMapping("/")
    @PreAuthorize("hasRole('APPROLE_ADMIN')")
    @ResponseBody
    public String home(OAuth2AuthenticationToken auth) throws MalformedURLException {
        String username = null;
        OAuth2User user = auth.getPrincipal();
        username = user.getName();

        return "Hello " + username + " "+ jwtSecurity.run();

    }

    @GetMapping("/login")
    public String login_action(Model model){


        return "login-page";
    }
//
//    @PostMapping("/auth/login")
//    @ResponseBody
//    public String login(@ModelAttribute User user){
//        System.out.println("user = " + user);
//
//        return "hello";
//        }
}
