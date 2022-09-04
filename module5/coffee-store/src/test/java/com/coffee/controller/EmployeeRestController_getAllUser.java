package com.coffee.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_getAllUser {

    @Autowired
    private MockMvc mockMvc;
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : getAllPosition()
     * test appUser dont have in database
     */
    @Test
    public void getAllUser_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/user/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : getAllPosition()
     * test appUser have in database
     */
    @Test
    public void getAllUser_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/user/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].password").value("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu"))
                .andExpect(jsonPath("content[0].userName").value("admin"))
                .andExpect(jsonPath("content[0].creationDate").value("2022-07-08"));
    }

}
