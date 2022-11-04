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
public class EmployeeRestController_getAllEmployee {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * getAllEmployee() have param searchName = null
     * param searchPhone have in database
     * param searchAccount have in database
     */
    @Test
    public void getAllEmployee_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/page?searchName=null&searchPhone=0905934232&searchAccount=manager").header("authorization",
                        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("$.content[0].id").value(1))
                .andExpect(jsonPath("$.content[0].name").value("Trần Thiên Minh"))
                .andExpect(jsonPath("$.content[0].address").value("27-28, ngõ 294 Vạn Phúc, Kim Mã, Hà Nội"))
                .andExpect(jsonPath("$.content[0].position").value("Quản Lý"))
                .andExpect(jsonPath("$.content[0].email").value("tranthienminh1351@gmail.com"))
                .andExpect(jsonPath("$.content[0].image").value("https://toigingiuvedep.vn/wp-content/uploads/2021/07/mau-anh-the-dep-chuan.jpg"))
                .andExpect(jsonPath("$.content[0].gender").value(1))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0905934232"))
                .andExpect(jsonPath("$.content[0].salary").value(15000000))
                .andExpect(jsonPath("$.content[0].appUser").value("manager"))
                .andExpect(jsonPath("$.content[0].birthday").value("1998-11-21"));
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * getAllEmployee() have param searchName = ''
     * param searchPhone have in database
     * param searchAccount have in database
     */
    @Test
    public void getAllEmployee_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName=&searchPhone=0935912341&searchAccount=admin"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("$.content[0].id").value(2))
                .andExpect(jsonPath("$.content[0].name").value("Tuyến 1"))
                .andExpect(jsonPath("$.content[0].address").value("Đà Nẵng 1"))
                .andExpect(jsonPath("$.content[0].position").value("Phục Vụ"))
                .andExpect(jsonPath("$.content[0].email").value("abc1@gmail.com"))
                .andExpect(jsonPath("$.content[0].image").value("aaaaaaa2"))
                .andExpect(jsonPath("$.content[0].gender").value(1))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0935912341"))
                .andExpect(jsonPath("$.content[0].salary").value(1500000))
                .andExpect(jsonPath("$.content[0].appUser").value("admin"))
                .andExpect(jsonPath("$.content[0].birthday").value("1990-01-01"));
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * getAllEmployee() have param searchName not have in database
     * param searchPhone have in database
     * param searchAccount have in database
     */
    @Test
    public void getAllEmployee_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName=aaaaaaaaaaaaaaaaaa&searchPhone=0935912341&searchAccount=admin"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * getAllEmployee() have param searchPhone = null
     * param searchName have in database
     * param searchAccount have in database
     */
    @Test
    public void getAllEmployee_12() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName=Tuyến 1&searchPhone=null&searchAccount=admin"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("$.content[0].id").value(2))
                .andExpect(jsonPath("$.content[0].name").value("Tuyến 1"))
                .andExpect(jsonPath("$.content[0].address").value("Đà Nẵng 1"))
                .andExpect(jsonPath("$.content[0].position").value("Phục Vụ"))
                .andExpect(jsonPath("$.content[0].email").value("abc1@gmail.com"))
                .andExpect(jsonPath("$.content[0].image").value("aaaaaaa2"))
                .andExpect(jsonPath("$.content[0].gender").value(1))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0935912341"))
                .andExpect(jsonPath("$.content[0].salary").value(1500000))
                .andExpect(jsonPath("$.content[0].appUser").value("admin"))
                .andExpect(jsonPath("$.content[0].birthday").value("1990-01-01"));
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * getAllEmployee() have param searchPhone = ''
     * param searchName have in database
     * param searchAccount have in database
     */
    @Test
    public void getAllEmployee_13() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName=Tuyến 1&searchPhone=&searchAccount=admin"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("$.content[0].id").value(2))
                .andExpect(jsonPath("$.content[0].name").value("Tuyến 1"))
                .andExpect(jsonPath("$.content[0].address").value("Đà Nẵng 1"))
                .andExpect(jsonPath("$.content[0].position").value("Phục Vụ"))
                .andExpect(jsonPath("$.content[0].email").value("abc1@gmail.com"))
                .andExpect(jsonPath("$.content[0].image").value("aaaaaaa2"))
                .andExpect(jsonPath("$.content[0].gender").value(1))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0935912341"))
                .andExpect(jsonPath("$.content[0].salary").value(1500000))
                .andExpect(jsonPath("$.content[0].appUser").value("admin"))
                .andExpect(jsonPath("$.content[0].birthday").value("1990-01-01"));
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * getAllEmployee() have param searchPhone = no have in database
     * param searchName have in database
     * param searchAccount have in database
     */
    @Test
    public void getAllEmployee_14() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName=Tuyến 1&searchPhone=0000000000&searchAccount=admin"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * getAllEmployee() have param searchAccount no have in database
     * param searchName have in database
     * param searchPhone have in database
     */
    @Test
    public void getAllEmployee_15() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName=Tuyến 1&searchPhone=0935912341&searchAccount=aaaaaaa"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * getAllEmployee() have param searchAccount =''
     * param searchName have in database
     * param searchPhone have in database
     */
    @Test
    public void getAllEmployee_16() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName=Tuyến 1&searchPhone=0935912341&searchAccount="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("$.content[0].id").value(2))
                .andExpect(jsonPath("$.content[0].name").value("Tuyến 1"))
                .andExpect(jsonPath("$.content[0].address").value("Đà Nẵng 1"))
                .andExpect(jsonPath("$.content[0].position").value("Phục Vụ"))
                .andExpect(jsonPath("$.content[0].email").value("abc1@gmail.com"))
                .andExpect(jsonPath("$.content[0].image").value("aaaaaaa2"))
                .andExpect(jsonPath("$.content[0].gender").value(1))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0935912341"))
                .andExpect(jsonPath("$.content[0].salary").value(1500000))
                .andExpect(jsonPath("$.content[0].appUser").value("admin"))
                .andExpect(jsonPath("$.content[0].birthday").value("1990-01-01"));
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * getAllEmployee() have param searchAccount = null
     * param searchName have in database
     * param searchPhone have in database
     */
    @Test
    public void getAllEmployee_21() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName=Tuyến 1&searchPhone=0935912341&searchAccount=null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("$.content[0].id").value(2))
                .andExpect(jsonPath("$.content[0].name").value("Tuyến 1"))
                .andExpect(jsonPath("$.content[0].address").value("Đà Nẵng 1"))
                .andExpect(jsonPath("$.content[0].position").value("Phục Vụ"))
                .andExpect(jsonPath("$.content[0].email").value("abc1@gmail.com"))
                .andExpect(jsonPath("$.content[0].image").value("aaaaaaa2"))
                .andExpect(jsonPath("$.content[0].gender").value(1))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0935912341"))
                .andExpect(jsonPath("$.content[0].salary").value(1500000))
                .andExpect(jsonPath("$.content[0].appUser").value("admin"))
                .andExpect(jsonPath("$.content[0].birthday").value("1990-01-01"));
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * getAllEmployee() have param searchAccount have in database
     * param searchName have in database
     * param searchPhone have in database
     */
    @Test
    public void getAllEmployee_131() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName=Tuyến 1&searchPhone=0935912341&searchAccount=admin"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("$.content[0].id").value(2))
                .andExpect(jsonPath("$.content[0].name").value("Tuyến 1"))
                .andExpect(jsonPath("$.content[0].address").value("Đà Nẵng 1"))
                .andExpect(jsonPath("$.content[0].position").value("Phục Vụ"))
                .andExpect(jsonPath("$.content[0].email").value("abc1@gmail.com"))
                .andExpect(jsonPath("$.content[0].image").value("aaaaaaa2"))
                .andExpect(jsonPath("$.content[0].gender").value(1))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0935912341"))
                .andExpect(jsonPath("$.content[0].salary").value(1500000))
                .andExpect(jsonPath("$.content[0].appUser").value("admin"))
                .andExpect(jsonPath("$.content[0].birthday").value("1990-01-01"));
    }
}