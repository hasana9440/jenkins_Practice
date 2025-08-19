package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddAndGetCustomer() throws Exception {
        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"John Doe\",\"contact\":\"1234567890\",\"bill\":500.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));

        mockMvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":2,\"name\":\"Jane Doe\",\"contact\":\"9876543210\",\"bill\":600.0}"))
                .andExpect(status().isOk());

        mockMvc.perform(put("/customers/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":2,\"name\":\"Jane Smith\",\"contact\":\"1112223333\",\"bill\":700.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane Smith"));
    }

    @Test
    public void testDeleteCustomer() throws Exception {
        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":3,\"name\":\"Mark\",\"contact\":\"5555555555\",\"bill\":800.0}"))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/customers/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
