package com.springapp.mvc.controller;

import com.springapp.config.AppConfig;
import com.springapp.config.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppConfig.class, WebConfig.class})

public class HelloControllerTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }

    @Test
    public void shop() throws Exception {
        mockMvc.perform(get("/shop"))
                .andExpect(status().isOk())
                .andExpect(view().name("shop"));
    }

    @Test
    public void addShopErrors() throws Exception {
        mockMvc.perform(post("/addShop"))
                 .andExpect(status().isOk())
                .andExpect(view().name("shop"))
                .andExpect(model().hasErrors());
    }

    @Test
    public void addShopSuccess() throws Exception {
        mockMvc.perform(post("/addShop").param("name", "aj").param("staffName", "bb"))
                .andExpect(view().name("redirect:/shop"))
                .andExpect(model().hasNoErrors());
    }

    @Test
    public void add() throws Exception {
        mockMvc.perform(get("/add.htm"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attributeExists("message"));
    }


    /*@Test
    public void getShopInJSON() throws Exception {
        mockMvc.perform(get("/{name}","aj").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("name").value("aj"));

    }*/
}
