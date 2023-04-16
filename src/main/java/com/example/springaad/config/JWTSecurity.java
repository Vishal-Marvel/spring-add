package com.example.springaad.config;

import com.microsoft.aad.msal4j.*;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Set;

@Getter
public class JWTSecurity {
    @Value("${clientId}")
    private String clientId;
    @Value("${clientSecret}")
    private String clientSecret;
    @Value("${tenantId}")
    private String tenantId;
    public String run() throws MalformedURLException {
        ConfidentialClientApplication app = ConfidentialClientApplication
                .builder("c0b1d6a3-4c63-4c06-94b9-daac46b4891c", ClientCredentialFactory.createFromSecret(".Vt8Q~iBZ2IgeKFiwKGpU7JeepEZicJLzPQLudo~"))
                .authority("https://login.microsoftonline.com/" + "a01dffac-c22e-45ba-b531-fcdf22abd834" + "/")
                .build();

        Set<String> scopes = Collections.singleton("https://graph.microsoft.com/.default");
        ClientCredentialParameters parameters = ClientCredentialParameters
                .builder(scopes)
                .build();
        IAuthenticationResult result = app.acquireToken(parameters).join();
        return result.accessToken();


    }
}
