package com.example.classm8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        Communication com = new Communication();
        //System.out.println(com.getUser("username"));

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println(com.getUser("username"));
            }
        };
        timer.schedule(task, 0, 100);

        launch();
    }
}