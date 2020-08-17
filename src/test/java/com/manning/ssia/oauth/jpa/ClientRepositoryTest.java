package com.manning.ssia.oauth.jpa;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
public class ClientRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ClientRepository clientRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(clientRepository).isNotNull();
    }

    @Test
  //  @Sql("createUser.sql")
    void findByName() {
        Client client = clientRepository.findByName("client");
        assertThat(client).isNotNull();
        System.out.println("found client "+client);
    }
}
