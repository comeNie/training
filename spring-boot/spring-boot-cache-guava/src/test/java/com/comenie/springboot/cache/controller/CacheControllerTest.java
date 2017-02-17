package com.comenie.springboot.cache.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 波 on 2017/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class CacheControllerTest {
    @Autowired
    private  CacheController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    @Test
    public void getByCache() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cache").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getByCacheWithSave() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cache").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/cache").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }


    @Test
    public void getByCacheWithSaveDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cache").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/cache").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.delete("/cache").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/cache").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}