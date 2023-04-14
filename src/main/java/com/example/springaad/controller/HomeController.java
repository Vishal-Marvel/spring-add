package com.example.springaad.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    @PreAuthorize("hasRole('APPROLE_ADMIN')")
    @ResponseBody
    public String home(OAuth2AuthenticationToken auth){
        String username = null;
        OAuth2User user = auth.getPrincipal();
        username = user.getName();
        return "Hello " + username;

    }

//    @GetMapping("/login")
//    public String login_action(Model model){
//
//        return "login-page";
//    }
//
//    @PostMapping("/auth/login")
//    @ResponseBody
//    public String login(@ModelAttribute User user){
//        System.out.println("user = " + user);
//
//        return "hello";
//        }
}
