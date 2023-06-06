package org.application.server.repository;

import org.application.server.model.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token, String> {

    Optional<Token> findTokenByValue(String tokenValue);
}
