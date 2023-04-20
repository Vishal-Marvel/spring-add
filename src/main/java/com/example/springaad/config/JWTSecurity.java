package com.example.springaad.config;

import com.microsoft.aad.msal4j.*;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Set;

@Getter
@Component
public class JWTSecurity {
    @Value("${client.Id}")
    private String clientId;
    @Value("${client.Secret}")
    private String clientSecret;
    @Value("${client.tenantId}")
    private String tenantId;
    public String run() throws MalformedURLException {
        ConfidentialClientApplication app = ConfidentialClientApplication
                .builder(clientId, ClientCredentialFactory.createFromSecret(clientSecret))
                .authority("https://login.microsoftonline.com/" + tenantId + "/")
                .build();

        Set<String> scopes = Collections.singleton("https://graph.microsoft.com/.default");
        ClientCredentialParameters parameters = ClientCredentialParameters
                .builder(scopes)
                .build();
        IAuthenticationResult result = app.acquireToken(parameters).join();
        return result.accessToken();


    }
}
