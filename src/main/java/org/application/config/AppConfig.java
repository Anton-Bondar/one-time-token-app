package org.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

import java.security.SecureRandom;
import java.util.Base64;

import static org.application.server.constant.EmailConstants.MESSAGE_TEMPLATE;

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

    @Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(MESSAGE_TEMPLATE);
        return message;
    }
}
