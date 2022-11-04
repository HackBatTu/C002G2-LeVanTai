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
public class DishRestController_editById {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    /**
     * @function:  This function is used on success with id = 10
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */

    @Test
    public void editDish_ok() throws Exception {
        DishDto dishDto = new DishDto();
        dishDto.setCode("CF-002");
        dishDto.setPrice(10000.0);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("logo.jpeg");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/10")
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
    public void editDish_not_ok1() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode(null);
        dishDto.setPrice(50000.0);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/10")
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
    public void editDish_not_ok2() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("");
        dishDto.setPrice(10000.0);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("logo.jpeg");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/10")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * @function:  this function use to test the validation  min length of  field code : (min length =3)
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */
    @Test
    public void editDish_not_ok3() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF");
        dishDto.setPrice(100000.0);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("logo.jpeg");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/10")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * @function:  this function use to test the validation  min  of  field price : (min = 5000.0)
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */
    @Test
    public void editDish_not_ok4() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF-01");
        dishDto.setPrice(4999.0);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("logo.jpeg");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/10")
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
    public void editDish_not_ok5() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF-001");
        dishDto.setPrice(null);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("logo.jpeg");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/10")
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
    public void editDish_not_ok6() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF-001");
        dishDto.setPrice(10000.0);
        dishDto.setName("");
        dishDto.setImage("logo.jpeg");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/10")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @function:  this function use to test the validation  min length of  field name :(min length = 5)
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */

    @Test
    public void editDish_not_ok7() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF-001");
        dishDto.setPrice(10000.0);
        dishDto.setName("ABCD");
        dishDto.setImage("logo.jpeg");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/10")
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
    public void editDish_not_ok8() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF-001");
        dishDto.setPrice(10000.0);
        dishDto.setName(null);
        dishDto.setImage("logo.jpeg");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/10")
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
    public void editDish_not_ok9() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF-001");
        dishDto.setPrice(10000.0);
        dishDto.setName("Cà Phê Sữa");
        dishDto.setImage("");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/10")
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
    public void editDish_not_ok10() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF-001");
        dishDto.setPrice(10000.0);
        dishDto.setName("Cà Phê Sữa");
        dishDto.setImage(null);

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/10")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * @function:  This function use if the id not of the Dish
     * @throws Exception
     * @creation: PhucLV
     * @Time 10/08/2022
     */
    @Test
    public void editDish_not_ok11() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF-001");
        dishDto.setPrice(10000.0);
        dishDto.setName("Cà Phê Sữa");
        dishDto.setImage("logo.jpeg");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/11")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
