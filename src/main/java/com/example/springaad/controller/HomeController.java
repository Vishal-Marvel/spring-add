package com.example.springaad.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;

@Controller
public class HomeController {

    @GetMapping("/")
    @PreAuthorize("hasRole('APPROLE_ADMIN')")
    @ResponseBody
    public String home(OAuth2AuthenticationToken auth, @AuthenticationPrincipal OidcUser oidcUser) {
        String username = null;
        OAuth2User user = auth.getPrincipal();
        username = user.getName();
        String idToken = oidcUser.getIdToken().getTokenValue();
        // Use the ID token as needed
        return "Hello, " +username +"\n"+ idToken;

    }

    @GetMapping("/login")
    public String login_action(Model model){


        return "login-page";
    }

}
