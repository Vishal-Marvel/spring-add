package com.example.springaad.controller;

import com.example.springaad.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    private static final ObjectMapper MAPPER = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonMapper.class);

    @GetMapping("/")
    @ResponseBody
    public String home(OAuth2AuthenticationToken auth){
        return "Hello";

    }

    @GetMapping("/graph")
    public String graph(@RegisteredOAuth2AuthorizedClient("graph") OAuth2AuthorizedClient graphClient) {
        // toJsonString() is just a demo.
        // oAuth2AuthorizedClient contains access_token. We can use this access_token to access the resource server.
        return toJsonString(graphClient);
    }

    private String toJsonString(OAuth2AuthorizedClient graphClient) {
        String clientJsonString;
        try {
            clientJsonString = MAPPER.writeValueAsString(graphClient);
        } catch (JsonProcessingException e) {
            LOGGER.warn("Error when transfer OAuth2AuthorizedClient to Json", e);
            clientJsonString = "Fail to generate Json String of current OAuth2AuthorizedClient";
        }
        LOGGER.info(clientJsonString);
        return clientJsonString;
    }
    @GetMapping("/login")
    public String login_action(Model model){

        return "login-page";
    }

    @PostMapping("/auth/login")
    @ResponseBody
    public String login(@ModelAttribute User user){
        System.out.println("user = " + user);

        return "hello";
        }
}
