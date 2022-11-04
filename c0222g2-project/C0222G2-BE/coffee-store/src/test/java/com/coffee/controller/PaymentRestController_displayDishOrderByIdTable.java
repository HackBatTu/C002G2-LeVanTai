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
public class PaymentRestController_displayDishOrderByIdTable {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create HoaNN
     * test check order list is null
     * @throws Exception
     */
    @Test
    public void displayDishOrderByIdTable_id_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/list/null")).
                andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * Create HoaNN
     * check order list is empty ,
     * @throws Exception
     */
    @Test
    public void displayDishOrderByIdTable_id_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/list/' '")).
                andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * Create HoaNN

     * dcheck order list is in the list

     * @throws Exception
     */
    @Test
    public void displayDishOrderByIdTable_id_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/list/100")).
                andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * Create HoaNN
     * id does not exist in database
     * @throws Exception
     */
    @Test
    public void displayDishOrderByIdTable_id_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/list")).
                andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * Create HoaNN
     * id have in list
     * @throws Exception
     */
    @Test
    public void displayDishOrderByIdTable_id_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/list/1")).
                andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].code").value("A-01"))
                .andExpect(jsonPath("content[0].name").value("Trà sữa"))
                .andExpect(jsonPath("content[0].price").value(15000))
                .andExpect(jsonPath("content[0].quantity").value(1));
    }
}
