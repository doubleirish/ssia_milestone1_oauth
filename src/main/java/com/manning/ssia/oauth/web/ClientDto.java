package com.manning.ssia.oauth.web;

import com.manning.ssia.oauth.jpa.Client;
import com.manning.ssia.oauth.jpa.Grant;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ClientDto {
    private int id;
    private String name;
    private String secret;
    private String scope;
    private String redirectUri;
    private List<String> grants;

    ClientDto( ){}

    ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.secret = client.getSecret();
        this.scope = client.getScope();
        this.redirectUri =client.getRedirectUri();
        this.grants = client.getGrants()
                .stream()
                .map(Grant::getGrant)
                .collect(Collectors.toList());
    }
}
