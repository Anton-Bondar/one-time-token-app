package org.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;
import java.util.Base64;

@Configuration
public class AppConfig {

    @Bean
    Base64.Encoder encoder() {
        return Base64.getEncoder();
    }

    @Bean
    SecureRandom secureRandom() {
        return new SecureRandom();
    }
}
