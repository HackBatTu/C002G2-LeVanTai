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
public class PaymentRestController_calculation {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Create HoaNN
     * Date create 11/08/2022
     * pay bills but id is null
     *
     * @throws Exception
     */
    @Test
    public void calculation_id_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/total/null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * Create HoaNN
     * Date create 11/08/2022
     * pay bills but id is empty
     *
     * @throws Exception
     */
    @Test
    public void calculation_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/total/' '"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * Create HoaNN
     * Date create 11/08/2022
     * pay bills but id haven't database
     *
     * @throws Exception
     */
    @Test
    public void calculation_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/total/100"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * Create HoaNN
     * Date create 11/08/2022
     * pay bills on a table when id have in database
     *
     * @throws Exception
     */
    @Test
    public void calculation_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/total/1"))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * Create HoaNN
     * Date create 11/08/2022
     * pay bills on a table when id have in database
     *
     * @throws Exception
     */
    @Test
    public void calculation_id_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/total/1"))
                .andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[1].name").value("Trà sữa"))
                .andExpect(jsonPath("content[1].price").value("15000"))
                .andExpect(jsonPath("content[1].quantity").value("1"));
    }

    /**
     * Create HoaNN
     * Date create 11/08/2022
     * pay bills on a table when id have in database but content is error
     *
     * @throws Exception
     */
    @Test
    public void calculation_id_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/total/2"))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(jsonPath("content[0].code").value("abcde"))
                .andExpect(jsonPath("content[0].name").value("Trà sữa"))
                .andExpect(jsonPath("content[0].price").value("15000"))
                .andExpect(jsonPath("content[0].quantity").value("1"));
    }
}
