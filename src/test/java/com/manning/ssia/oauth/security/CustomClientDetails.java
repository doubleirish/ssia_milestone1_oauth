package com.manning.ssia.oauth.security;

import com.manning.ssia.oauth.jpa.Authority;
import com.manning.ssia.oauth.jpa.Client;
import com.manning.ssia.oauth.jpa.Grant;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;
import java.util.stream.Collectors;

public class CustomClientDetails implements ClientDetails {

    private Client client;

    public CustomClientDetails(Client client) {
        this.client =client;
    }

    @Override
    public String getClientId() {
        return client.getName();
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return client.getSecret();
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return new HashSet<>(Arrays.asList(client.getScope() ));

    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return null;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return new HashSet<>(Arrays.asList(client.getRedirectUri()));
    }
    @Override
    public Collection<GrantedAuthority> getAuthorities() {

        return client.getGrants().stream()
                .map(Grant::getGrant)
                .map(grant -> new SimpleGrantedAuthority(grant))
                .collect(Collectors.toList());

    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return 300;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return 300;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
