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
public class PaymentRestController_getCoffeeTablePage {
    @Autowired
    private MockMvc mockMvc;


    /**
     * Create HoaNN
     * Date create 11/08/2022
     * <p>
     * paging tables have null
     *
     * @throws Exception
     */
    @Test
    public void getCoffeeTablePage_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/page=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create HoaNN
     * Date create 11/08/2022
     * <p>
     * paging tables have empty
     *
     * @throws Exception
     */
    @Test
    public void getCoffeeTablePage_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/page=' '"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create HoaNN
     * Date create 11/08/2022
     * <p>
     * paging tables not have in database
     *
     * @throws Exception
     */
    @Test
    public void getCoffeeTablePage_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/page=44"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Create HoaNN
     * Date create 11/08/2022
     * <p>
     * paging tables have not in database size =0
     *
     * @throws Exception
     */
    @Test
    public void getCoffeeTablePage_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/page?page=0"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Create HoaNN
     * Date create 11/08/2022
     * <p>
     * paging tables have in database
     *
     * @throws Exception
     */
    @Test
    public void getCoffeeTablePage_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/page?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create HoaNN
     * Date create 11/08/2022
     * <p>
     * paging tables have in database
     *
     * @throws Exception
     */
    @Test
    public void getCoffeeTablePage_11_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/page?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(8))
                .andExpect(jsonPath("content[0].code").value("A-01"))
                .andExpect(jsonPath("content[0].name").value("Trà sữa"));
    }
}
