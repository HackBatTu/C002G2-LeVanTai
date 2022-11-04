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
public class EmployeeRestController_findEmployeeById {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * findEmployeeById() have param id = null
     */
    //find id = null
    @Test
    public void findEmployeeById_id_1() {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/find/null"))
                    .andDo(print()).andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * findEmployeeById() have param id = ''
     */
    @Test
    public void findEmployeeById_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/find/"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * findEmployeeById() have param id not have in database
     */
    @Test
    public void findEmployeeById_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/find/15"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * findEmployeeById() have param id have in database
     */
    @Test
    public void findEmployeeById_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/find/1").header("authorization",
                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg"))
                .andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("Trần Thiên Minh"))
                .andExpect(jsonPath("birthday").value("1998-11-21"))
                .andExpect(jsonPath("phoneNumber").value("0905934232"))
                .andExpect(jsonPath("address").value("27-28, ngõ 294 Vạn Phúc, Kim Mã, Hà Nội"))
                .andExpect(jsonPath("email").value("tranthienminh1351@gmail.com"))
                .andExpect(jsonPath("salary").value(15000000))
                .andExpect(jsonPath("image").value("https://toigingiuvedep.vn/wp-content/uploads/2021/07/mau-anh-the-dep-chuan.jpg"))
                .andExpect(jsonPath("position").value("Quản Lý"))
                .andExpect(jsonPath("appUser").value("manager"))
                .andExpect(jsonPath("gender").value(1));
    }
}