package com.example.classm8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LecturesController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonChat;

    @FXML
    private ListView<?> enrolledCoursesList;

    @FXML
    private Label title;

    @FXML
    void back(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("enrolledCourses.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        root.setStyle("-fx-background-color: olivedrab;");
        Scene scene = new Scene(root, 1200, 900);
        //Image icon = new Image(HelloApplication.class.getResourceAsStream("/classm8icon.png"));
        //stage.getIcons().add(icon);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Enrolled Courses");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void chat(ActionEvent event) {

    }

    @FXML
    void select(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("lectureVideo.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        root.setStyle("-fx-background-color: olivedrab;");
        Scene scene = new Scene(root, 1200, 900);
        //Image icon = new Image(HelloApplication.class.getResourceAsStream("/classm8icon.png"));
        //stage.getIcons().add(icon);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Enrolled Courses");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}