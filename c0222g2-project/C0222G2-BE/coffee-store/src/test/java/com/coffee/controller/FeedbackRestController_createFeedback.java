package com.coffee.controller;

import com.coffee.dto.FeedbackDto;
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
public class FeedbackRestController_createFeedback {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Created by: DiepTT
     * Date created: 11/08/2022
     * Function: Check not-null of "creator"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_creator_13() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator(null);
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check required of "creator"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_creator_14() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check format of "creator"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_creator_15() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("thi hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 11/08/2022
     * Function: Check min length (2 characters) of "creator"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_creator_16() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("T");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check max length (30 characters) of "creator"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_creator_17() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyen Thi Hoa Nguyen Thi Hoa Nguyen Thi Hoa Nguyen Thi Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 11/08/2022
     * Function: Check not-null of "email"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_email_13() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail(null);
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check required of "email"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_email_14() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Date updated: 11/08/2022
     * Function: Check format (without "@domain") of "email"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_email_15_check_1() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 11/08/2022
     * Function: Check format (without "domain") of "email"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_email_15_check_2() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 11/08/2022
     * Function: Check format (without "local-part") of "email"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_email_15_check_3() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 11/08/2022
     * Function: Check min length (5 characters) of "email"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_email_16() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("n@g");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check max length (254 characters) of "email"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_email_17() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoa" +
                "nguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoa" +
                "nguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoa" +
                "nguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoa" +
                "@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 11/08/2022
     * Function: Check not-null of "content"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_content_13() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent(null);
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check required of "content"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_content_14() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 11/08/2022
     * Function: Check min length (2 characters) of "content"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_content_16() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Q");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check required of "rating"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_rating_13() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(null);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 11/08/2022
     * Function: Check min (1) of "rating"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_rating_16() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(0);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 11/08/2022
     * Function: Check max (5) of "rating"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_rating_17() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(6);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 11/08/2022
     * Function: Check null of "image"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_image_13() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check not-required of "image"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_image_14() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check valid input data of "feedback" and save "feedback" to the database
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_18() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(4);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .header("authorization",
                                "Bearer " + TokenUtil.token)
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
