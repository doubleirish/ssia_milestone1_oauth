package com.manning.ssia.oauth.jpa;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository   extends CrudRepository<User, Integer> {

  User findByUsername(String name);
 }
