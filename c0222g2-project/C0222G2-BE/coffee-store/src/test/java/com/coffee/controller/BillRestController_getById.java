package com.coffee.controller;

import javafx.beans.DefaultProperty;
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
public class BillRestController_getById {

    @Autowired
    private MockMvc mockMvc;

    /**
     *  Created by: HauLT
     *  Date created: 10/08/2022
     *  function: check with case id equals null
     *
     * @throws Exception
     */

    @Test
    public void getById_id_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/rest/bill/detail/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case id is empty
     * @throws Exception
     */

    @Test
    public void getById_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/rest/bill/detail/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case id does not exist
     * @throws Exception
     */

    @Test
    public void getById_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/rest/bill/detail/15"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case id exists
     * @throws Exception
     */

    @Test
    public void getById_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/rest/bill/detail/1 "))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("billCode").value("BIll-1"))
                .andExpect(jsonPath("creationDate").value("2022-12-12"))
                .andExpect(jsonPath("isDeleted").value(false));
    }



}
