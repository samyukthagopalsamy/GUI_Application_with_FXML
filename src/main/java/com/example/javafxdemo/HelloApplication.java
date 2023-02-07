package com.example.javafxdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;

public class HelloApplication extends Application {

    private Stage mainStage;

    public void start(Stage stage) {
        mainStage = stage;
        mainStage.setTitle("Tasty Sub");

        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            AnchorPane pane = loader.load();

            HelloController controller = loader.getController();
            controller.setMainStage(mainStage);

            Scene scene = new Scene(pane, 400, 300);
            mainStage.setScene(scene);
            mainStage.show();

        } catch (IOException e) {
            System.err.println("Error while loading FXML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
