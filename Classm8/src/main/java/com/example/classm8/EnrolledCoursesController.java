package com.example.classm8;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EnrolledCoursesController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button buttonChoose;

    @FXML
    private Button buttonLogOut;

    @FXML
    private AnchorPane enrolledCourses;

    @FXML
    private ListView<String> enrolledCoursesList;

    @FXML
    private Label title;

    @FXML
    void choose(ActionEvent event) {
        String course = (String) enrolledCoursesList.getSelectionModel().getSelectedItem();

        GlobalCourse.gc = course;
        Communication com = new Communication();
        String[] nizLekcija = com.getLectures(GlobalCourse.gc);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("lectures.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LecturesController upisaniKursevi = loader.getController();
        upisaniKursevi.ucitajLekcije(nizLekcija);
        upisaniKursevi.labela(GlobalCourse.gc);

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
    void logout(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
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

    public void ucitajKurseve(String[] s) {
        enrolledCoursesList.getItems().addAll(s);
    }

}


