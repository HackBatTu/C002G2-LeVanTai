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
public class FeedbackRestController_getAllFeedback {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by : LuanTV
     * Date created: 10/08/2022
     * Function: check searchCreator
     *
     * @throws Exception
     */
    @Test
    public void getAllFeedback_7_searchCreator() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=null"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_8_searchCreator() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator= "))
                .andDo(print())
                .andExpect(status().is(204));
    }
    @Test
    public void getAllFeedback_9_searchCreator() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=cong"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_10_searchCreator() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=hau"))
                .andDo(print())
                .andExpect(status().is(204));
    }


    /**
     * Created by : LuanTV
     * Date created: 10/08/2022
     * Function: check searchStartDate
     *
     * @throws Exception
     */
    @Test
    public void getAllFeedback_7_searchStartDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=null&searchEndDate=2022-02-04"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_8_searchStartDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate= &searchEndDate= "))
                .andDo(print())
                .andExpect(status().is(204));
    }
    @Test
    public void getAllFeedback_9_searchStartDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-03-05&searchEndDate=2022-03-30"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_10_searchStartDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-02-06&searchEndDate=2022-02-06"))
                .andDo(print())
                .andExpect(status().is(204));
    }


    /**
     * Created by : LuanTV
     * Date created: 11/08/2022
     * Function: check searchEndDate
     *
     * @throws Exception
     */
    @Test
    public void getAllFeedback_7_searchEndDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-02-04&searchEndDate=null"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_8_searchEndDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-02-04&searchEndDate= "))
                .andDo(print())
                .andExpect(status().is(204));
    }
    @Test
    public void getAllFeedback_9_searchEndDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-02-19&searchEndDate=2022-02-28"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_10_searchEndDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-02-06&searchEndDate=2022-02-06"))
                .andDo(print())
                .andExpect(status().is(204));
    }


    /**
     * Created by : LuanTV
     * Date created: 10/08/2022
     * Function: check exact search results
     *
     * @throws Exception
     */
    @Test
    public void getAllFeedback_11() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=d&searchStartDate=2022-02-05&searchEndDate=2022-02-05"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].id").value(3))
                .andExpect(jsonPath("content[0].code").value("FB003"))
                .andExpect(jsonPath("content[0].code").value("FB0003"))
                .andExpect(jsonPath("content[0].code").value("FB0003"))
                .andExpect(jsonPath("content[0].creator").value("Diệp"))
                .andExpect(jsonPath("content[0].email").value("diepdn@gmail.com"))
                .andExpect(jsonPath("content[0].content").value("Giá tiền vừa đủ"))
                .andExpect(jsonPath("content[0].rating").value(3))
                .andExpect(jsonPath("content[0].feedbackDate").value("2022-02-05"))
                .andExpect(jsonPath("content[0].image").value("https://www.vivosmartphone.vn/uploads/MANGOADS/ch%E1%BB%A5p%20%E1%BA%A3nh/%E1%BA%A2nh%20%C4%91%E1%BB%93%20u%E1%BB%91ng/fD6Mguu.jpg"));

    }
}
