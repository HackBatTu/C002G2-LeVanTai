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
public class BillRestController_getAllBill {

    @Autowired
    private MockMvc mockMvc;


    /**
     * Created by: HauLT
     * Date created: 11/08/2022
     * function: check case returns list with size 0
     * @throws Exception
     */

    @Test
    public void getAllBill_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: HauLT
     * Date created: 11/08/2022
     * function: check case returns list with size greater than 0
     * @throws Exception
     */

    @Test
    public void getAllBill_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(13))
                .andExpect(jsonPath("content[0].billCode").value("BIll-1"))
                .andExpect(jsonPath("content[0].creationDate").value("2022-12-12"));

    }


    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 1 field equals null
     * @throws Exception
     */

    @Test
    public void getAllBill_7_searchDate() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill?searchParamCode=BIll-1&searchParamDate=null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 1 field equals null
     * @throws Exception
     */

    @Test
    public void getAllBill_7_searchCode() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill?searchParamCode=null&searchParamDate=2022-12-12"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 2 fields are equal to null
     * @throws Exception
     */

    @Test
    public void getAllBill_7() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill?searchParamCode=null&searchParamDate=null"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 2 fields are empty
     * @throws Exception
     */

    @Test
    public void getAllBill_8() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill?searchParamCode=&searchParamDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 1 field is empty
     * @throws Exception
     */

    @Test
    public void getAllBill_8_searchDate() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill?searchParamCode=BIll-1&searchParamDat="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 1 field is empty
     * @throws Exception
     */

    @Test
    public void getAllBill_8_searchCode() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill?searchParamCode=&searchParamDate=2022-12-12"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 1 field does not exist
     * @throws Exception
     */

    @Test
    public void getAllBill_9_searchCode() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill?searchParamCode=BIll-1&searchParamDate=2033-12-12"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 1 field does not exist
     * @throws Exception
     */

    @Test
    public void getAllBill_9_searchDate() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill?searchParamCode=BIll-1788?searchParamDate=2022-12-12"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 2 fields do not exist
     * @throws Exception
     */

    @Test
    public void getAllBill_9() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill?searchParamCode=BIll1?searchParamDate=2050-12-12"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: checks for existence but returns a list of size 0
     * @throws Exception
     */

    @Test
    public void getAllBill_10() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill?searchParamCode=BIll-1&searchParamDate=2022-12-12"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case the field exists
     * @throws Exception
     */

    @Test
    public void getAllBill_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill?searchParamCode=BIll-1&searchParamDate=2022-12-12"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].billCode").value("BIll-1"))
                .andExpect(jsonPath("content[0].creationDate").value("2022-12-12"));
    }

}
