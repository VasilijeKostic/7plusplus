package com.example.classm8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    private Scene scene;
    private Parent root;
    @Override
    public void start(Stage stage) {
        try {
            root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
            root.setStyle("-fx-background-color: olivedrab;");
            scene = new Scene(root, 1200, 900);
            //Image icon = new Image(HelloApplication.class.getResourceAsStream("/classm8icon.png"));
            //stage.getIcons().add(icon);
            stage.setTitle("Classm8 Login");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}



