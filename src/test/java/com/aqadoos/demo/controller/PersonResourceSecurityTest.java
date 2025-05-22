package com.aqadoos.demo.controller;

import org.junit.Test; // Changed from org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonResourceSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenAccessProtectedEndpointWithoutAuthentication_thenUnauthorized() throws Exception {
        mockMvc.perform(get("/person"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "testuser", roles = {"USER"})
    public void whenAccessProtectedEndpointWithMockOAuth2User_thenOk() throws Exception {
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk());
    }
}
