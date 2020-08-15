package com.manning.ssia.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {

    //used for testing access to secured endpoints e.g
    // curl -u john:12345 http://localhost:8080/users
    // curl -u admin:secret http://localhost:8080/clients
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails john = User.withUsername("john")
//                .password("12345")
//                .authorities("ROLE_USER")
//                .build();
//        userDetailsService.createUser(john);
//        UserDetails admin = User.withUsername("root")
//                .password("secret")
//                .authorities("ROLE_ADMIN")
//                .build();
//        userDetailsService.createUser(admin);
//        return userDetailsService;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}