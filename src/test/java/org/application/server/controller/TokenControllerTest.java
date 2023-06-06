package org.application.server.controller;

import org.application.server.service.TokenValidationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.application.server.controller.TokenController.RESPONSE_TEMPLATE;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TokenControllerTest {

    private static final String API_TOKEN_PATH = "/api/token/";
    private static final String VALID_PATH_VARIABLE = "valid-token";
    private static final String INVALID_PATH_VARIABLE = "invalid-token";
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TokenValidationService tokenValidationService;

    @Test
    public void testVerifyValidTokenReturnsOk() throws Exception {
        String expectedBody = buildExpectedResponse(VALID_PATH_VARIABLE, "green", "is");
        when(tokenValidationService.isValid(VALID_PATH_VARIABLE)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.get(API_TOKEN_PATH + VALID_PATH_VARIABLE))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedBody));
    }

    @Test
    public void testVerifyInvalidTokenReturnsNotAcceptable() throws Exception {
        String expectedBody = buildExpectedResponse(INVALID_PATH_VARIABLE, "red", "isn't");
        when(tokenValidationService.isValid(INVALID_PATH_VARIABLE)).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.get(API_TOKEN_PATH + INVALID_PATH_VARIABLE))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().string(expectedBody));
    }

    private String buildExpectedResponse(String token, String textColor, String placeHolderValue) {
        return String.format(RESPONSE_TEMPLATE, textColor, token, placeHolderValue);
    }
}