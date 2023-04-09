package com.example.classm8;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class EnrolledCoursesController implements Initializable {

    @FXML
    private Button buttonChat;

    @FXML
    private Button buttonLogOut;

    @FXML
    private AnchorPane enrolledCourses;

    @FXML
    private ListView<String> enrolledCoursesList;

    @FXML
    private Label title;

    String s[] = {"Tmi", "Kpj", "Dpj"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        enrolledCoursesList.getItems().addAll(s);
    }
}

