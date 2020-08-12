package com.manning.ssia.oauth.jpa;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {

 Client findByName(String name);
 }
