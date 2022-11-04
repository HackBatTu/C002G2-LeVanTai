package com.coffee.controller;

import com.coffee.dto.DishDto;
import com.coffee.model.dish.DishType;
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
public class DishRestController_createDish {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @function:  This function is used on success
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */

    @Test
    public void createDish_name_ok() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CFass");
        dishDto.setPrice(10000.0);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");
        dishDto.setIsDeleted(false);
        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * @function:  This function use test validation if the code field is null
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */
    @Test
    public void createDish_name_not_ok1() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode(null);
        dishDto.setPrice(10000.0);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * @function:  This function use test validation if the code field is empty
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */
    @Test
    public void createDish_name_not_ok2() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("");
        dishDto.setPrice(10000.0);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * @function:  this function use to test the validation  min length of  field code
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */
    @Test
    public void createDish_name_not_ok3() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF");
        dishDto.setPrice(10000.0);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * @function:  this function use to test the validation  min  of  field price
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */
    @Test
    public void createDish_name_not_ok4() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF-01");
        dishDto.setPrice(10.0);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @function:  This function use test validation if the price field is null
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */
    @Test
    public void createDish_name_not_ok5() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF-01");
        dishDto.setPrice(null);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * @function:  This function use test validation if the name field is empty
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */
    @Test
    public void createDish_name_not_ok6() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF--01");
        dishDto.setPrice(1000.0);
        dishDto.setName("");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @function:  this function use to test the validation  min length of  field name
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */

    @Test
    public void createDish_name_not_ok7() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF--01");
        dishDto.setPrice(1000.0);
        dishDto.setName("Ca");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * @function:  this function use to test the validation of  field name is null
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */

    @Test
    public void createDish_name_not_ok8() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF--01");
        dishDto.setPrice(1000.0);
        dishDto.setName(null);
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @function:  This function use test validation if the image field is empty
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */
    @Test
    public void createDish_name_not_ok9() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF--01");
        dishDto.setPrice(1000.0);
        dishDto.setName("Cà Phê Sữa");
        dishDto.setImage("");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @function:  This function use test validation if the image field is null
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */
    @Test
    public void createDish_name_not_ok10() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF--01");
        dishDto.setPrice(1000.0);
        dishDto.setName("Cà Phê Sữa");
        dishDto.setImage(null);

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
