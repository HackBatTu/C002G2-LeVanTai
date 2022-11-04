package com.coffee.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DishRestController_deleteDish {
    @Autowired
    private MockMvc mockMvc;

    /**
     * this function use to test value = null
     * created by : HieuCD
     * Date created: 10/08/2022
     * @throws Exception
     */
    @Test
    public void deleteDish_19() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dishType/delete/")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test value = ""
     * created by : HieuCD
     * Date created: 10/08/2022
     * @throws Exception
     */
    @Test
    public void deleteDish_20() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dishType/delete/''")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test false format
     * created by : HieuCD
     * Date created: 10/08/2022
     * @throws Exception
     */
    @Test
    public void deleteDish_21() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dishType/delete/'hello'")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test value < minlength
     * created by : HieuCD
     * Date created: 10/08/2022
     * @throws Exception
     */
    @Test
    public void deleteDish_22() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dishType/delete/-1")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test value > maxlength
     * created by : HieuCD
     * Date created: 10/08/2022
     * @throws Exception
     */
    @Test
    public void deleteDish_23() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dishType/delete/2")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test valid value
     * created by : HieuCD
     * Date created: 10/08/2022
     * @throws Exception
     */
    @Test
    public void deleteDish_24() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dishType/delete/1")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

}
