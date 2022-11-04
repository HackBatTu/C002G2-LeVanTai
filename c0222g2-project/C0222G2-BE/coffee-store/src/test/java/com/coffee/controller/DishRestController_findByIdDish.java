package com.coffee.controller;

import com.coffee.model.dish.DishType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DishRestController_findByIdDish {
    @Autowired
    private MockMvc mockMvc;

    /**
     * @function: This function is used to check when id is null
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */
    @Test
    public void findById_id1() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dish/null")
        )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * @function:  This function is used on success when id = 1
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */

    @Test
    public void findById_id_1() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dish/1")
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("code").value("C-F001"))
                .andExpect(jsonPath("name").value("cà phê sữa"))
                .andExpect(jsonPath("price").value(10000.0))
                .andExpect(jsonPath("image").value("logo.jpeg"))
                .andExpect(jsonPath("isDeleted").value(false))
                .andExpect(jsonPath("dishType.id").value(1))
                .andExpect(jsonPath("creationDate").value("1995-01-14"));
    }
}
