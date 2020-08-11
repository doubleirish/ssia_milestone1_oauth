package com.manning.ssia.oauth.jpa;

import javax.persistence.Entity;

@Entity
public class User {

    private Long Id;
    private String username;
    private String password;

}
