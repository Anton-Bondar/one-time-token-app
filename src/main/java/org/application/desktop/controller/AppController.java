package org.application.desktop.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.application.desktop.service.TokenGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppController {
    @Autowired
    private TokenGeneratorService tokenGeneratorService;
    @FXML
    private TextArea tokenTextArea;
    @FXML
    private Button sendButton;

    @FXML
    private void onClickGenerate() {
        String token = tokenGeneratorService.generateToken();
        tokenTextArea.setText(token);
        sendButton.setDisable(false);
    }
}
