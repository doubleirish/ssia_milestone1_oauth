package com.manning.ssia.oauth.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClientControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void clients() throws Exception {
        String jsonStr =  this.restTemplate.getForObject("http://localhost:" + port + "/clients",  String.class);
        assertThat(jsonStr).contains("acme");
    }

    @Test
    public void clientById() throws Exception {
        UserDto userDto =  this.restTemplate.getForObject("http://localhost:" + port + "/clients/1",  UserDto.class);
        assertThat(userDto.getId()).isEqualTo(1);
        assertThat(userDto.getUsername()).isEqualTo("acme");
    }


    @Test
    public void createClient() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("newuser");
        userDto.setPassword("newpass");
        userDto.setAuthorities(Arrays.asList("user","admin"));
        UserDto returnUserDto =  this.restTemplate.postForObject("http://localhost:" + port + "/clients",  userDto,UserDto.class);

        System.out.println(returnUserDto);

        assertThat(returnUserDto.getUsername()).isEqualTo(userDto.getUsername());
    }

}