package com.manning.ssia.oauth.security;

import com.manning.ssia.oauth.jpa.Authority;
import com.manning.ssia.oauth.jpa.Grant;
import com.manning.ssia.oauth.jpa.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails  implements UserDetails {
        private User user;

        public CustomUserDetails(User user) {
            this.user = user;
        }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities().stream()
                .map(Authority::getAuthority)
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "CustomUserDetails{" +
                "username=" + user.getUsername() +
                "authorities=" + this.getAuthorities()  +
                '}';
    }
}