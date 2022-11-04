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
public class DishOrderRestController_getAllOrder {
    @Autowired
    private MockMvc mockMvc;



    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check error, this function will return error 4xx
     *  and content
     * @throws Exception
     */
    @Test
    public void getAllOrder_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/dish-order/get-dish-list/").header("authorization",
                                        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check, and return json array contains total page, total element
     *  and content
     * @throws Exception
     */
    @Test
    public void getAllOrder_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/dish-order/get-dish-list/").header("authorization",
                                        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[1].id").value(3))
                .andExpect(jsonPath("content[1].quantity").value(0))
                .andExpect(jsonPath("content[1].coffeeTable.id").value(1))
                .andExpect(jsonPath("content[1].code").value("OD-930"))
                .andExpect(jsonPath("content[1].bill.id").value(1))
                .andExpect(jsonPath("content[1].dish.id").value(1))
                .andExpect(jsonPath("content[1].employee.id").value(1));
    }
}
