package com.manning.ssia.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();


        http.authorizeRequests(authorize -> authorize
                .mvcMatchers("/h2-console", "/h2-console/**").permitAll()
                .mvcMatchers("/users").hasRole("USER")
                .mvcMatchers("/users/**").hasRole("USER")
                .mvcMatchers( "/clients").hasRole("ADMIN")
                .mvcMatchers( "/clients/**").hasRole("ADMIN")
                .anyRequest().denyAll()
        );
    }

//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable()
//                .authorizeRequests().antMatchers("/users/**").authenticated()
//                .and()
//                .authorizeRequests().antMatchers("/clients/**").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/h2-console/**").permitAll();
//
//        httpSecurity.headers().frameOptions().disable();
//    }

}
