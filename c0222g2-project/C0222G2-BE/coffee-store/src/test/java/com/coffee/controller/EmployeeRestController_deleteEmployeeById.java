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
public class EmployeeRestController_deleteEmployeeById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * deleteEmployeeById() have param id = null
     */
    @Test
    public void deleteEmployeeById_id_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/rest/employee/delete/null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * deleteEmployeeById() have param id = ''
     */
    @Test
    public void deleteEmployeeById_id_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/rest/employee/delete/"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * deleteEmployeeById() have param id not have in database
     */
    @Test
    public void deleteEmployeeById_id_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/rest/employee/delete/15"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * deleteEmployeeById() have param id have in database
     */
    @Test
    public void deleteEmployeeById_id_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/rest/employee/delete/1").header("authorization",
                        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg"))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}