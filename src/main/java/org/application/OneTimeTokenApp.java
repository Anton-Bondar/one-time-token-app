package org.application;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.application.desktop.service.UIInitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OneTimeTokenApp extends Application {
	private ConfigurableApplicationContext context;
	private Parent rootNode;

	//@TODO make UIInitService bean
	private UIInitService uiInitService = new UIInitService();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() {
		context = SpringApplication.run(OneTimeTokenApp.class);
		rootNode = uiInitService.loadRootNode(context);
	}

	@Override
	public void start(Stage primaryStage) {
		uiInitService.loadScene(primaryStage, rootNode);
	}

	@Override
	public void stop() {
		context.stop();
	}
}
