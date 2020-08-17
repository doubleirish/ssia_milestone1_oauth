package com.manning.ssia.oauth.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OAuthCreateTokenTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void generateAccessTokenForPasswordGrant() throws Exception {
        mvc.perform(
                post("/oauth/token")
                        .with(httpBasic("client", "secret"))
                        .queryParam("grant_type", "password")
                        .queryParam("username", "john")
                        .queryParam("password", "12345")
                        .queryParam("scope", "read")
        ).andDo(print())
                .andExpect(jsonPath("$.access_token").exists())
                .andExpect(jsonPath("$.refresh_token").exists())
                .andExpect(status().isOk());

    }


    @Test
    void generateAccessTokenForClientCredentialsGrant() throws Exception {
        mvc.perform(
                post("/oauth/token")
                        .with(httpBasic("client", "secret"))
                        .queryParam("grant_type", "client_credentials")
                        .queryParam("scope", "read")
        ).andDo(print())
                .andExpect(jsonPath("$.access_token").exists())

                .andExpect(status().isOk());

    }
}
