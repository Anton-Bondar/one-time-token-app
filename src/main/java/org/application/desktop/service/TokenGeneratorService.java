package org.application.desktop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HexFormat;

@Service
public class TokenGeneratorService {
    public static final int BYTES_COUNT = 16;
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenGeneratorService.class);
    private final SecureRandom secureRandom;

    public TokenGeneratorService(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
    }

    /**
     * Generates token using BYTES_COUNT constant.
     * The number of generated bytes can be increased to improve key reliability.
     *
     * @return new random token
     */
    public String generateToken() {
        byte[] randomBytes = new byte[BYTES_COUNT];
        secureRandom.nextBytes(randomBytes);
        String result = HexFormat.of().formatHex(randomBytes);
        LOGGER.info("Generated token: {}", result);
        return result;
    }

    /**
     * Decodes HEX string.
     *
     * @param token to decode
     * @return decoded string
     */
    public byte[] decodeToken(String token) {
        return HexFormat.of().parseHex(token);
    }
}
