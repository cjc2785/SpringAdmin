package com.ss.lms.controller;

import com.ss.lms.model.Author;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.regex.Matcher;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private AdminController adminController;
    @Before
    public void setUp() throws Exception
    {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController)
                .build();

    }
    @Test
    public void testAdminControllerAuthor() throws Exception
    {
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/lms/admin/author/")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(2)));
    }

}
