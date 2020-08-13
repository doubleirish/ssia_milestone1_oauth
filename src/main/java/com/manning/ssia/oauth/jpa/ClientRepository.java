package com.manning.ssia.oauth.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

 Client findByName(String name);
 }
