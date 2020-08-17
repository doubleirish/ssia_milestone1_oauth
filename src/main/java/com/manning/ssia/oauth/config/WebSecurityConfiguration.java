package com.manning.ssia.oauth.config;

import com.manning.ssia.oauth.security.JpaClientDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import java.util.HashMap;
import java.util.Map;

//
// @Order(-5001)
@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    @Bean(name = "authenticationManagerBean")
    public AuthenticationManager authenticationManagerBean()
            throws Exception {
       return  super.authenticationManagerBean();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        String idForEncode = "bcrypt";
        Map encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("noop", NoOpPasswordEncoder.getInstance());

        return new DelegatingPasswordEncoder(idForEncode, encoders);

    }





    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable();


        http.authorizeRequests()
                .mvcMatchers("/users/**").permitAll()
                .mvcMatchers("/clients/**").permitAll();


//        http.authorizeRequests(authorize -> authorize
//                .mvcMatchers("/h2-console", "/h2-console/**").permitAll()
//                .mvcMatchers("/users").hasRole("USER")
//                .mvcMatchers("/users/**").hasRole("USER")
//
//                .anyRequest().permitAll());

         super.configure(http);

    }




}
