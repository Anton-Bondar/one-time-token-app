package org.application.server.service;

import org.application.server.model.Token;
import org.application.server.repository.TokenRepository;
import org.springframework.stereotype.Service;

@Service
public class TokenProcessingService {

    private final TokenRepository tokenRepository;

    public TokenProcessingService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public boolean isValid(String tokenValue) {
        return true;
    }

    public void saveToken(String tokenValue) {
        Token token = new Token(tokenValue);
        tokenRepository.save(token);
    }
}
