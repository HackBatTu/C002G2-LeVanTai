package com.coffee.controller;

import com.coffee.dto.DishDto;
import com.coffee.dto.DishOrderDto;
import com.coffee.model.bill.Bill;
import com.coffee.model.coffee_table.CoffeeTable;
import com.coffee.model.dish.Dish;
import com.coffee.model.employee.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DishOrderRestController_createOrder {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check create order success
     * @throws Exception
     */
    @Test
    public void createOrder_18() throws Exception {
        DishOrderDto dishOrderDto = new DishOrderDto();
        Dish dishDto = new Dish();
        dishDto.setId(1);
        dishOrderDto.setDish(dishDto);
        Bill billDto = new Bill();
        billDto.setId(1);
        dishOrderDto.setBill(billDto);
        Employee employeeDto = new Employee();
        employeeDto.setId(1);
        dishOrderDto.setEmployee(employeeDto);
        CoffeeTable coffeeTableDto = new CoffeeTable();
        coffeeTableDto.setId(1);
        dishOrderDto.setCoffeeTable(coffeeTableDto);
        dishOrderDto.setQuantity(2);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/dish-order/create-dishOrder").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                    .content(this.objectMapper.writeValueAsString(dishOrderDto))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check dish is null then false create
     * @throws Exception
     */
    @Test
    public void createOrder_dish_13() throws Exception {
        DishOrderDto dishOrderDto = new DishOrderDto();
        dishOrderDto.setDish(null);
        Bill billDto = new Bill();
        billDto.setId(1);
        dishOrderDto.setBill(billDto);
        Employee employeeDto = new Employee();
        employeeDto.setId(1);
        dishOrderDto.setEmployee(employeeDto);
        CoffeeTable coffeeTableDto = new CoffeeTable();
        coffeeTableDto.setId(1);
        dishOrderDto.setCoffeeTable(coffeeTableDto);
        dishOrderDto.setQuantity(2);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/dish-order/create-dishOrder").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(dishOrderDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check bill is null then false create
     * @throws Exception
     */
    @Test
    public void createOrder_bill_13() throws Exception {
        DishOrderDto dishOrderDto = new DishOrderDto();
        Dish dishDto = new Dish();
        dishDto.setId(1);
        dishOrderDto.setDish(dishDto);
        dishOrderDto.setBill(null);
        Employee employeeDto = new Employee();
        employeeDto.setId(1);
        dishOrderDto.setEmployee(employeeDto);
        CoffeeTable coffeeTableDto = new CoffeeTable();
        coffeeTableDto.setId(1);
        dishOrderDto.setCoffeeTable(coffeeTableDto);
        dishOrderDto.setQuantity(2);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/dish-order/create-dishOrder").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(dishOrderDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check employee is null then false create
     * @throws Exception
     */
    @Test
    public void createOrder_employee_13() throws Exception {
        DishOrderDto dishOrderDto = new DishOrderDto();
        Dish dishDto = new Dish();
        dishDto.setId(1);
        dishOrderDto.setDish(dishDto);
        Bill billDto = new Bill();
        billDto.setId(1);
        dishOrderDto.setBill(billDto);
        dishOrderDto.setEmployee(null);
        CoffeeTable coffeeTableDto = new CoffeeTable();
        coffeeTableDto.setId(1);
        dishOrderDto.setCoffeeTable(coffeeTableDto);
        dishOrderDto.setQuantity(2);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/dish-order/create-dishOrder").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(dishOrderDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check coffee table is null then false create
     * @throws Exception
     */
    @Test
    public void createOrder_coffeeTable_13() throws Exception {
        DishOrderDto dishOrderDto = new DishOrderDto();
        Dish dishDto = new Dish();
        dishDto.setId(1);
        dishOrderDto.setDish(dishDto);
        Bill billDto = new Bill();
        billDto.setId(1);
        dishOrderDto.setBill(billDto);
        Employee employeeDto = new Employee();
        employeeDto.setId(1);
        dishOrderDto.setEmployee(employeeDto);
        dishOrderDto.setCoffeeTable(null);
        dishOrderDto.setQuantity(2);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/dish-order/create-dishOrder").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(dishOrderDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check quantity is null then false create
     * @throws Exception
     */
    @Test
    public void createOrder_quantity_13() throws Exception {
        DishOrderDto dishOrderDto = new DishOrderDto();
        Dish dishDto = new Dish();
        dishDto.setId(1);
        dishOrderDto.setDish(dishDto);
        Bill billDto = new Bill();
        billDto.setId(1);
        dishOrderDto.setBill(billDto);
        Employee employeeDto = new Employee();
        employeeDto.setId(1);
        dishOrderDto.setEmployee(employeeDto);
        CoffeeTable coffeTableDto = new CoffeeTable();
        coffeTableDto.setId(1);
        dishOrderDto.setCoffeeTable(coffeTableDto);
        dishOrderDto.setQuantity(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/dish-order/create-dishOrder").header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(dishOrderDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check quantity is less than min length then false create
     * @throws Exception
     */
    @Test
    public void createOrder_quantity_16() throws Exception {
        DishOrderDto dishOrderDto = new DishOrderDto();
        Dish dishDto = new Dish();
        dishDto.setId(1);
        dishOrderDto.setDish(dishDto);
        Bill billDto = new Bill();
        billDto.setId(1);
        dishOrderDto.setBill(billDto);
        Employee employeeDto = new Employee();
        employeeDto.setId(1);
        dishOrderDto.setEmployee(employeeDto);
        CoffeeTable coffeTableDto = new CoffeeTable();
        coffeTableDto.setId(1);
        dishOrderDto.setCoffeeTable(coffeTableDto);
        dishOrderDto.setQuantity(0);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/dish-order/create-dishOrder")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(dishOrderDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check quantity is greater than max length then false create
     * @throws Exception
     */
    @Test
    public void createOrder_quantity_17() throws Exception {
        DishOrderDto dishOrderDto = new DishOrderDto();
        Dish dishDto = new Dish();
        dishDto.setId(1);
        dishOrderDto.setDish(dishDto);
        Bill billDto = new Bill();
        billDto.setId(1);
        dishOrderDto.setBill(billDto);
        Employee employeeDto = new Employee();
        employeeDto.setId(1);
        dishOrderDto.setEmployee(employeeDto);
        CoffeeTable coffeeTableDto = new CoffeeTable();
        coffeeTableDto.setId(1);
        dishOrderDto.setCoffeeTable(coffeeTableDto);
        dishOrderDto.setQuantity(6);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/dish-order/create-dishOrder")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg")
                        .content(this.objectMapper.writeValueAsString(dishOrderDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
