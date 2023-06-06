package org.application.server.service;

import org.application.server.model.Token;
import org.application.server.repository.TokenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenValidationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenValidationService.class);
    private final TokenRepository tokenRepository;

    public TokenValidationService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    /**
     * Validates input token if token presents in DB return false otherwise save token and return false.
     *
     * @param tokenValue token value
     * @return boolean flag
     */
    public boolean isValid(String tokenValue) {
        Optional<Token> token = tokenRepository.findTokenByValue(tokenValue);
        return token
                .map(value -> {
                    LOGGER.debug("Token '{}' exists in DB", value);
                    return false;
                })
                .orElseGet(() -> {
                    Token newToken = new Token(tokenValue);
                    tokenRepository.save(newToken);
                    LOGGER.debug("Token '{}' was saved in DB", newToken.getValue());
                    return true;
                });
    }
}
