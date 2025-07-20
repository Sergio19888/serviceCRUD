package com.mr_robot.serviceCRUD.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mr_robot.serviceCRUD.DTO.ClientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCreateClientSuccessfully() throws Exception {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Иван");
        clientDTO.setSurName("Петров");
        clientDTO.setEmail("ivan.integration@test.com");
        clientDTO.setPhoneNumber("1234567890");

        mockMvc.perform(post("/api/clients") // замени на свой URL
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Иван"))
                .andExpect(jsonPath("$.email").value("ivan.integration@test.com"));
    }
}

