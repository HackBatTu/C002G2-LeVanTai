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
public class FeedbackRestController_getFeedbackById {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by : LuanTV
     * Date created: 10/08/2022
     * function: check find by id feedback
     *
     * @throws Exception
     */

    @Test
    public void getFeedbackById_id_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getFeedbackById_id_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getFeedbackById_id_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/9"))
                .andDo(print())
                .andExpect(status().is(204));

    }

    /**
     * Created by : LuanTV
     * Date created: 10/08/2022
     * function: check exact id search results
     *
     * @throws Exception
     */

    @Test
    public void getFeedbackById_id_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(3))
                .andExpect(jsonPath("code").value("FB003"))
                .andExpect(jsonPath("creator").value("Diệp"))
                .andExpect(jsonPath("email").value("diepdn@gmail.com"))
                .andExpect(jsonPath("content").value("Giá tiền vừa đủ"))
                .andExpect(jsonPath("rating").value(3))
                .andExpect(jsonPath("feedbackDate").value("2022-02-05"))
                .andExpect(jsonPath("image").value("https://www.vivosmartphone.vn/uploads/MANGOADS/ch%E1%BB%A5p%20%E1%BA%A3nh/%E1%BA%A2nh%20%C4%91%E1%BB%93%20u%E1%BB%91ng/fD6Mguu.jpg"));
    }
}
