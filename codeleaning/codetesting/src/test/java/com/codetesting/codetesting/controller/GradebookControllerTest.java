package com.codetesting.codetesting.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


@AutoConfigureMockMvc //autoconfigure
@SpringBootTest
class GradebookControllerTest {

    @Autowired
    private MockMvc mockMvc;  /// inject the mockMvc
    @Test
    public void getStudentsHttpRequest () throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk()).andReturn();  // define expectation
        ModelAndView mav = mvcResult.getModelAndView();
        ModelAndViewAssert.assertViewName(mav, "index");  //  Perform web requests
         //tep 5: Assert results

        //Can also assert model attributes.
        //Retrieve model attribute objects for fine-grained asserts
    }

}