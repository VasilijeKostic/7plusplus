package com.example.classm8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
            root.setStyle("-fx-background-color: olivedrab;");
            Scene scene = new Scene(root, 600, 400);
            Image icon = new Image(HelloApplication.class.getResourceAsStream("/classm8icon.png"));
            stage.getIcons().add(icon);
            stage.setTitle("Classm8 Login");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}