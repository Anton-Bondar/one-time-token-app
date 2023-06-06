package org.application.server.controller;

import org.application.server.service.TokenProcessingService;
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

   private final TokenProcessingService tokenProcessingService;

   public TokenController(TokenProcessingService tokenProcessingService) {
      this.tokenProcessingService = tokenProcessingService;
   }

   @GetMapping("{token-value}")
   public ResponseEntity<String> verifyToken(@PathVariable("token-value") String token) {
      tokenProcessingService.saveToken(token);
      return buildResponse(token, "green", "is");
   }

   private ResponseEntity<String> buildResponse(String token, String textColor, String placeHolderValue) {
      String body = RESPONSE_TEMPLATE.formatted(textColor, token, placeHolderValue);
      return ResponseEntity.status(HttpStatus.OK)
              .contentType(MediaType.TEXT_HTML)
              .body(body);
   }
}
