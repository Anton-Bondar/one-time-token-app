package org.application.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static org.application.server.constant.EmailConstants.SUBJECT;

@Service
public class EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender javaMailSender;
    private final SimpleMailMessage template;

    @Autowired
    public EmailService(JavaMailSender javaMailSender, SimpleMailMessage template) {
        this.javaMailSender = javaMailSender;
        this.template = template;
    }

    /**
     * Forms a message using {@link org.application.server.constant.EmailConstants} and sends it.
     *
     * @param to    mail receiver
     * @param token token value
     */
    public void sendEmail(String to, String token) {
        javaMailSender.send(buildMessage(to, token));
        LOGGER.info("Token was sent to email {}", to);
    }

    private SimpleMailMessage buildMessage(String to, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        String body = String.format(template.getText(), token);
        message.setTo(to);
        message.setSubject(SUBJECT);
        message.setText(body);
        return message;
    }
}
