package org.application.server.constant;

public interface EmailConstants {
    String MESSAGE_TEMPLATE = "This is link to your public token: http://localhost:8080/api/token/%s";
    String SUBJECT = "[one-time-token-app] public token";
}
