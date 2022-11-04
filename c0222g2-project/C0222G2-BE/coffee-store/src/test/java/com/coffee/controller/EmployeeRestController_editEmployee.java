package com.coffee.controller;

import com.coffee.dto.EmployeeDTOCreate;
import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Employee;
import com.coffee.model.employee.Position;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_editEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test userName = null
     */
    @Test
    public void editEmployee_userName_13() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName(null);

        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test userName = ""
     */
    @Test
    public void editEmployee_userName_14() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("");

        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : saveEmployee()
     * test userName: first input = number
     */
    @Test
    public void editEmployee_userName_15() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("1user123");

        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test userName < 6 char
     */
    @Test
    public void editEmployee_userName_16() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user1");

        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test userName >20 char
     */
    @Test
    public void editEmployee_userName_16_1() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test name = null
     */
    @Test
    public void editEmployee_name_13() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employee.setName(null);
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test name = ""
     */
    @Test
    public void editEmployee_name_14() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");
        employee.setName("");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test format birthday
     */
    @Test
    public void editEmployee_birthday_15() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("20000101"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test birthday = null
     */
    @Test
    public void editEmployee_birthday_13() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employee.setName("Lê Văn An");
        employee.setBirthday(null);
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test birthday = ""
     */
    @Test
    public void editEmployee_birthday_14() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");
        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf(""));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test phoneNumber = null
     */
    @Test
    public void editEmployee_phoneNumber_13() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber(null);
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test phoneNumber = ""
     */
    @Test
    public void editEmployee_phoneNumber_14() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test format phoneNumber
     */
    @Test
    public void editEmployee_phoneNumber_15() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("00000000000000000");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test address = null
     */
    @Test
    public void editEmployee_address_13() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");
        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress(null);
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test address = ""
     */
    @Test
    public void editEmployee_address_14() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");
        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test address = !@$#%^&*()
     */
    @Test
    public void editEmployee_address_15() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");
        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("!@#$%^&*()");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test email = null
     */
    @Test
    public void editEmployee_email_13() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");
        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà Nẵng");
        employee.setGender(0);
        employee.setEmail(null);
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : saveEmployee()
     * test email = ""
     */
    @Test
    public void editEmployee_email_14() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà Nẵng");
        employee.setGender(0);
        employee.setEmail("");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : saveEmployee()
     * test format email
     */
    @Test
    public void editEmployee_email_15() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà Nẵng");
        employee.setGender(0);
        employee.setEmail("levana");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test salary = null
     */
    @Test
    public void editEmployee_salary_13() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employee.setName("Lê Văn An");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà Nẵng");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(null);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test salary < 0
     */
    @Test
    public void editEmployee_salary_15() throws Exception {

        Employee employee = new Employee();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employee.setName("Lê Văn An");

        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà Nẵng");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(-11.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(1);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test employee edit success
     */
    @Test
    public void editEmployee_18() throws Exception {


        Employee employee = new Employee();

        AppUser appUser = new AppUser();
        appUser.setId(1);
        appUser.setUserName("user123");

        appUser.setCreationDate(Date.valueOf(LocalDate.now()));
        appUser.setPassword("123456");
        appUser.setIsDeleted(false);
        employee.setAppUser(appUser);

        employee.setId(1);
        employee.setName("Lê Văn An");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = simpleDateFormat.parse("2001-01-01");
        Date date = new Date(date1.getTime());
        employee.setBirthday(date);

        employee.setPhoneNumber("0936369999");
        employee.setAddress("Tp.Đà NẴNG");
        employee.setGender(0);
        employee.setEmail("levana@gmail.com");
        employee.setSalary(1000000.0);
        employee.setImage("http/:firebase.levana.png");
        employee.setIsDeleted(false);

        Position position = new Position();
        position.setId(2);
        employee.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}