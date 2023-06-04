package org.application.desktop.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.application.desktop.service.TokenGeneratorService;
import org.application.server.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppController {
    @Autowired
    private TokenGeneratorService tokenGeneratorService;
    @Autowired
    private EmailService emailService;
    @FXML
    private TextArea tokenTextArea;
    @FXML
    private Button sendButton;
    @FXML
    private TextField emailTextField;

    @FXML
    private void onClickGenerate() {
        String token = tokenGeneratorService.generateToken();
        tokenTextArea.setText(token);
        sendButton.setDisable(false);
    }

    public void onClickSend() {
        String email = emailTextField.getText();
        String token = tokenTextArea.getText();
        //@TODO email validation
        emailService.sendEmail(email, token);
    }
}
