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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SimpleEmailController_sendSimpleEmail {

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
    public void sendSimpleEmail_username_13() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/sendSimpleEmail")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test for username is not found in database
     * @creator PhuongTD
     * date-create 10/8/2022
     * @throws Exception
     */
    // 91. [item] not found in database => return status 401
    @Test
    public void sendSimpleEmail_username_91() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("staff1");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/sendSimpleEmail")
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
    public void sendSimpleEmail_username_18() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("tranthienminh135");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/sendSimpleEmail")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Test for wrong token
     * @creator PhuongTD
     * date-create 10/8/2022
     * @throws Exception
     */
    // 93. [item] is not same with token's server -> return 302 status
    @Test
    public void getUsernameForChangePassword_token_93() throws Exception {
        String tempToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdGFmZiIsImV4cCI6MTY2MDEzOTYyNiwiaWF0IjoxNjYwMTIxNjI2fQ.wCAsQ1bTO2kj6c5qvBSLFcWPtsCBxogqO3XY7smnGgJchLeO4KdKSSAq0yD6qDu__Xilbk1ftbsunyUS19G7NQ";
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/forgotPassword/" + tempToken))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    /**
     * func check token null
     * @creator PhuongTD
     * date-create 11/8/2022
     * @throws Exception
     */
    @Test
    public void getUsernameForChangePassword_token_7() throws Exception {
        String tempToken = null;
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/forgotPassword/" + tempToken))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    /**
     * func check token is empty
     * @creator PhuongTD
     * date-create 11/8/2022
     * @throws Exception
     */
    @Test
    public void getUsernameForChangePassword_token_8() throws Exception {
        String tempToken = "";
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/forgotPassword/" + tempToken))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test for wrong token
     * @creator PhuongTD
     * date-create 10/8/2022
     * @throws Exception
     */
    // 93. [item] is not same with token's server
    @Test
    public void changePassword_token_93() throws Exception {
        String tempToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdGFmZiIsImV4cCI6MTY2MDEzOTYyNiwiaWF0IjoxNjYwMTIxNjI2fQ.wCAsQ1bTO2kj6c5qvBSLFcWPtsCBxogqO3XY7smnGgJchLeO4KdKSSAq0yD6qDu__Xilbk1ftbsunyUS19G7NQ";
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setToken(tempToken);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/changePassword/" + jwtRequest.getToken())
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * func check token null
     * @creator PhuongTD
     * date-create 11/8/2022
     * @throws Exception
     */
    @Test
    public void changePassword_token_7() throws Exception {
        String tempToken = null;
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setToken(tempToken);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/changePassword/" + jwtRequest.getToken())
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * func check token is empty
     * @creator PhuongTD
     * date-create 11/8/2022
     * @throws Exception
     */
    @Test
    public void changePassword_token_8() throws Exception {
        String tempToken = "";
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setToken(tempToken);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/changePassword/" + jwtRequest.getToken())
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * READ ME!
     * Because token auto generate, i can't write full test for method getUsernameForChangePassword and changePassword
     */
}
