package com.example.classm8;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField textPassword;

    @FXML
    private TextField textUsername;

    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonRegister;

    @FXML
    void login(ActionEvent event) {
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
        // Milos START
        GlobalUsername.gu = (textUsername.getText());
        Communication com = new Communication();
        String[] nizKurseva = com.getCourses(GlobalUsername.gu);
        // Milos END
    }

    @FXML
    void register(ActionEvent event) {
    }

}
