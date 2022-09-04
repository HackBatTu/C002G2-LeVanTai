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
public class EmployeeRestController_findById {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : findById() param id
     * test employee id = null
     */
    @Test
    public void findById_id_1() throws Exception {
    this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/rest/employee/findId/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : findById() param id
     * test employee id = 1
     */
    @Test
    public void findById_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/rest/employee/findId/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("Lê Văn Tài"))
                .andExpect(jsonPath("birthday").value("2000-01-01"))
                .andExpect(jsonPath("phoneNumber").value("0989989989"))
                .andExpect(jsonPath("address").value("Tx.Nghi Sơn, Thanh Hóa"))
                .andExpect(jsonPath("gender").value(1))
                .andExpect(jsonPath("email").value("levantai1496@gmail.com"))
                .andExpect(jsonPath("salary").value(100000000))
                .andExpect(jsonPath("image").value("http:/firebase.sdsdasd"))
                .andExpect(jsonPath("isDeleted").value(0))
                .andExpect(jsonPath("position.id").value(1))
                .andExpect(jsonPath("appUser.userName").value("user123"));
    }

}
