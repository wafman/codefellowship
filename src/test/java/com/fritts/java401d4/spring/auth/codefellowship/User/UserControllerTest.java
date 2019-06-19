package com.fritts.java401d4.spring.auth.codefellowship.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    UserController userController;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void contextLoads(){}

    @Test
    public void testControllerIsAutowired(){
        assertNotNull(userController);
    }

    @Test
    public void testRequestToHelloGivesHello() throws Exception{
        mockMvc.perform(get("/")).andExpect(content().string(containsString("Welcome to Code Fellowship")));
    }

    @Test
    public void testRequestToCapitalizeWord() throws Exception{
        mockMvc.perform(get("/login")).andExpect(content().string(containsString("Login")));
    }

    @Test
    public void testRequestToReverse() throws Exception{
        mockMvc.perform(get("/signup")).andExpect(content().string(containsString("Sign Up")));
    }
}