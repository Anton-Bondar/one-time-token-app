package org.application.desktop.service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.net.URL;

/**
 * Inits JavaFX UI token-app.fxml
 */
public class UIInitService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UIInitService.class);

    public Parent loadRootNode(ConfigurableApplicationContext context) {
        URL url = getClass().getClassLoader().getResource("token-app.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setControllerFactory(context::getBean);
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            LOGGER.error("error during UI initialization", e);
        }
        return null;
    }

    public void loadScene(Stage primaryStage, Parent rootNode) {
        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.setTitle("one-time-token-app");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
