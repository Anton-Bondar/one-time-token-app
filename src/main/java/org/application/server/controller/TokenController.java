package org.application.server.controller;

import org.application.server.service.TokenValidationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/token")
public class TokenController {
    private static final String RESPONSE_TEMPLATE = """
            <html>
            <body>
            <h2 style="color: %s;">Your token '%s' %s valid</h2>
            <body>
            <html>
            """;

    private final TokenValidationService tokenValidationService;

    public TokenController(TokenValidationService tokenValidationService) {
        this.tokenValidationService = tokenValidationService;
    }

    @GetMapping("{token-value}")
    public ResponseEntity<String> verifyToken(@PathVariable("token-value") String token) {
        if (tokenValidationService.isValid(token))
            return buildResponse(token, "green", "is", HttpStatus.OK);
        else
            return buildResponse(token, "red", "isn't", HttpStatus.NOT_ACCEPTABLE);
    }

    private ResponseEntity<String> buildResponse(String token, String textColor, String placeHolderValue, HttpStatus status) {
        String body = RESPONSE_TEMPLATE.formatted(textColor, token, placeHolderValue);
        return ResponseEntity.status(status)
                .contentType(MediaType.TEXT_HTML)
                .body(body);
    }
}
