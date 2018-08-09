package com.waylau.spring.boot.blog.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void sayHello() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
        ResultActions resultActions = mockMvc.perform(requestBuilder);
        resultActions.andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World!")));
    }
}