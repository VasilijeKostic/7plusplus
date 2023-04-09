package com.example.classm8;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class EnrolledCoursesController implements Initializable {

    @FXML
    private AnchorPane enrolledCourses;

    @FXML
    private ListView<String> enrolledCoursesList;
    String s[] = {"KPJ", "TMI", "DPJ"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        enrolledCoursesList.getItems().addAll(s);
    }
}
