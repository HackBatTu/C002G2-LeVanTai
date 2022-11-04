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
public class DishRestController_getDishPageSearch {
    @Autowired
    private MockMvc mockMvc;

    /**
     * this function use to test  search value = null
     * created by : HieuCD
     * Date created: 11/08/2022
     * @throws Exception
     */
    @Test
    public void getDishPageSearch_7() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dish/searchDish/codeDish=null")
        ).andDo(print()).andExpect(status().is4xxClientError());

    }

    /**
     * this function use to test  search value = ""
     * created by : HieuCD
     * Date created: 11/08/2022
     * @throws Exception
     */
    @Test
    public void getDishPageSearch_8() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dish/searchDish/codeDish=")
        ).andDo(print()).andExpect(status().is4xxClientError());

    }

    /**
     * this function use to test  search value don't have in database
     * created by : HieuCD
     * Date created: 11/08/2022
     * @throws Exception
     */
    @Test
    public void getDishPageSearch_9() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dish/searchDish/codeDish=hello")
        ).andDo(print()).andExpect(status().is4xxClientError());

    }

    /**
     * this function use to test  search value  have in database, have totalPage =0
     * created by : HieuCD
     * Date created: 11/08/2022
     * @throws Exception
     */
    @Test
    public void getDishPageSearch_10() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dish/searchDish/codeDish=babyShark")
        ).andDo(print()).andExpect(status().is4xxClientError());

    }

    /**
     * this function use to test  search value  have in database, have totalPage >0
     * created by : HieuCD
     * Date created: 11/08/2022
     * @throws Exception
     */
    @Test
    public void getDishPageSearch_11() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dish/searchDish/codeDish=0")
        ).andDo(print()).andExpect(status().is4xxClientError());

    }
}
