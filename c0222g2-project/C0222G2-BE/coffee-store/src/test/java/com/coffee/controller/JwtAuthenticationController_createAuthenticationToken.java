package com.coffee.controller;

import com.coffee.model.jwt.JwtRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtAuthenticationController_createAuthenticationToken {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Test for username is null
     * @creator PhuongTD
     * date-create 10/8/2022
     * @throws Exception
     */
    @Test
    public void createAuthenticationToken_username_7() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test for username is empty
     * @creator PhuongTD
     * date-create 11/8/2022
     * @throws Exception
     */
    @Test
    public void createAuthenticationToken_username_8() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test for password null
     * @creator PhuongTD
     * date-create 10/8/2022
     * @throws Exception
     */
    @Test
    public void createAuthenticationToken_password_7() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("admin");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test for password is empty
     * @creator PhuongTD
     * date-create 11/8/2022
     * @throws Exception
     */
    @Test
    public void createAuthenticationToken_password_8() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setPassword("");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test for username input wrong
     * @creator PhuongTD
     * date-create 10/8/2022
     * @throws Exception
     */
    // 91. [item] not found in database => return status 401
    @Test
    public void createAuthenticationToken_username_91() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("admin1");
        jwtRequest.setPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test for password input wrong
     * @creator PhuongTD
     * date-create 10/8/2022
     * @throws Exception
     */
    // 92. [item] unauthorized => return status 401
    @Test
    public void createAuthenticationToken_password_92() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("admin");
        jwtRequest.setPassword("1234");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test for successfully
     * @creator PhuongTD
     * date-create 10/8/2022
     * @throws Exception
     */
    @Test
    public void createAuthenticationToken_username_password_18() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("manager");
        jwtRequest.setPassword("123456a@");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("username").value("manager"))
                .andExpect(jsonPath("grantList[0]").value("ROLE_ADMIN"))
                .andExpect(jsonPath("grantList[1]").value("ROLE_STAFF"))
                .andExpect(jsonPath("grantList[2]").value("ROLE_USER"));
    }
}
