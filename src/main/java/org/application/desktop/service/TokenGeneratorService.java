package org.application.desktop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class TokenGeneratorService {
    //The number of generated bytes can be increased to improve key reliability.
    public static final int BYTES_COUNT = 16;
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenGeneratorService.class);
    @Autowired
    private SecureRandom secureRandom;

    @Autowired
    private Base64.Encoder encoder;

    public String generateToken() {
        byte[] randomBytes = new byte[BYTES_COUNT];
        secureRandom.nextBytes(randomBytes);
        String result = encoder.encodeToString(randomBytes);
        LOGGER.info("Generated token: {}", result);
        return result;
    }
}
