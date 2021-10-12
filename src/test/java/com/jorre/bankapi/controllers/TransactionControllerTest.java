package com.jorre.bankapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jorre.bankapi.controllers.requestBodies.TransactionRequestBody;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for TransactionController
 */
@SpringBootTest
@AutoConfigureMockMvc
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void performTransaction_andExpectOk() throws Exception {
        TransactionRequestBody requestBody = new TransactionRequestBody();
        requestBody.setSourceAccountName("Account 2");
        requestBody.setDestinationAccountName("Account 1");
        requestBody.setAmount(150.0);

        RequestBuilder request =
                post("/api/account/transfer/")
                        .content(mapper.writeValueAsString(requestBody))
                        .contentType(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(request).andExpect(status().isOk());
    }

}
