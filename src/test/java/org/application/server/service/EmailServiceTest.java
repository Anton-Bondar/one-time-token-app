package org.application.server.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.application.server.constant.EmailConstants.SUBJECT;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class EmailServiceTest {
    private static final String TEST_EMAIL = "example@gmail.com";
    private static final String TEST_TOKEN = "dfdfdf==";
    private static final String EXPECTED_MESSAGE = "This is link to your public token: http://localhost:8080/api/token/dfdfdf==";
    @MockBean
    private JavaMailSender mailSender;

    @Autowired
    private EmailService emailService;

    @Test
    public void sendEmail() {
        emailService.sendEmail(TEST_EMAIL, TEST_TOKEN);

        verify(mailSender, times(1)).send(buildExpectedMessage());
    }

    private SimpleMailMessage buildExpectedMessage() {
        SimpleMailMessage result = new SimpleMailMessage();
        result.setTo(TEST_EMAIL);
        result.setSubject(SUBJECT);
        result.setText(EXPECTED_MESSAGE);
        return result;
    }
}