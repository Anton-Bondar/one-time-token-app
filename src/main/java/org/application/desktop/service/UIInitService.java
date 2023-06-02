package org.application.desktop.service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.net.URL;

public class UIInitService {

    public Parent loadRootNode(ConfigurableApplicationContext context) {
        URL url = getClass().getClassLoader().getResource("token-app.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setControllerFactory(context::getBean);
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            //TODO log exception
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
