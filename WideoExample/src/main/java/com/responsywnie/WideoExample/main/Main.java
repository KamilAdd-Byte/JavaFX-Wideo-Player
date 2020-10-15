package com.responsywnie.WideoExample.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("WideoExample KamilAdd-Byte");
		stage.show();
		BorderPane pane = FXMLLoader.load(getClass().getResource("/mainPane.fxml"));
		Scene scene = new Scene(pane);


		scene.setOnMouseClicked(doubleClick -> {
			if (doubleClick.getClickCount() == 2){
                stage.setFullScreen(true);
			}
		});
		stage.setScene(scene);
	}
}
