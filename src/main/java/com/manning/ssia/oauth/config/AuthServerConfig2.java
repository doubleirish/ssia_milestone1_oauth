package com.manning.ssia.oauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig2
        extends AuthorizationServerConfigurerAdapter {
    @Value("${jwt.key}")
    private String jwtKey;



    @Resource(name="authenticationManagerBean")
    private AuthenticationManager authenticationManager;


    @Resource(name = "jpaClientDetailsService")
    private ClientDetailsService clientDetailsService;



//    @Override
//    public void configure( ClientDetailsServiceConfigurer clients)  throws Exception {
//        clients.inMemory()
//                .withClient("client")
//                .secret("{noop}secret")
//                .authorizedGrantTypes("password", "refresh_token","authorization_code","client_credentials")
//                .authorities("ROLE_CLIENT")
//                .redirectUris("http://localhost:8080/authorized")
//                .scopes( "read","trust");
//    }

    @Override
    public void configure(  AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(this.authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(jwtAccessTokenConverter());
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }
    public TokenStore tokenStore() {
        return new JwtTokenStore( jwtAccessTokenConverter());
    }


    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(jwtKey);
        return converter;
    }
}