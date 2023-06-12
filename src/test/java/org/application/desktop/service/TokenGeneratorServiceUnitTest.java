package org.application.desktop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TokenGeneratorServiceUnitTest {
    private TokenGeneratorService tokenGeneratorService;

    private SecureRandom secureRandom;

    @BeforeEach
    void setUp() {
       secureRandom = new SecureRandom();
       tokenGeneratorService = new TokenGeneratorService(secureRandom);
    }

    @Test
    @DisplayName("Checks generated token bytes count")
    void generateToken() {
        String token = tokenGeneratorService.generateToken();

        byte[] bytes = tokenGeneratorService.decodeToken(token);
        assertEquals(TokenGeneratorService.BYTES_COUNT, bytes.length);
    }
}