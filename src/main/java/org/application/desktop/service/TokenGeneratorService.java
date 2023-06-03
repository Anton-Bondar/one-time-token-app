package org.application.desktop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class TokenGeneratorService {
    //The number of generated bytes can be increased to improve key reliability.
    public static final int BYTES_COUNT = 16;
    @Autowired
    private SecureRandom secureRandom;

    @Autowired
    private Base64.Encoder encoder;

    public String generateToken() {
        byte[] randomBytes = new byte[BYTES_COUNT];
        secureRandom.nextBytes(randomBytes);
        return encoder.encodeToString(randomBytes);
    }
}
