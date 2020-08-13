package com.manning.ssia.oauth.web;

import com.manning.ssia.oauth.jpa.Authority;
import com.manning.ssia.oauth.jpa.Client;
import com.manning.ssia.oauth.jpa.Grant;
import com.manning.ssia.oauth.jpa.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ClientDto {
    private int id;
    private String name;
    private String redirectUri;
    private List<String> grants;

    ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.redirectUri =client.getRedirectUri();
        this.grants = client.getGrants()
                .stream()
                .map(Grant::getGrant)
                .collect(Collectors.toList());
    }
}
