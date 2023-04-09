package com.example.classm8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.*;

public class Media {

    @FXML
    private Button buttonChat;

    @FXML
    private Button buttonClassmate;

    @FXML
    private Button buttonLogOut;

    @FXML
    private Button buttonPause;

    @FXML
    private Button buttonPlay;

    @FXML
    private Button buttonReset;

    @FXML
    private Label title;

    @FXML
    void chat(ActionEvent event) {
    }

    @FXML
    void findClassmate(ActionEvent event) {
        Communication com = new Communication();
        String[] userData = com.getUser(GlobalUsername.gu);
        User user = new User(userData[0], userData[1], userData[2]);

        String[] onlineUsernames = com.getOnlineUsers(GlobalLecture.gl);
        List<User> onlineUsersList = new ArrayList<>();
        for (String username : onlineUsernames) {
            String[] tempUserData = com.getUser(username);
            User tempOnlineUser = new User(tempUserData[0], tempUserData[1], tempUserData[2]);

            onlineUsersList.add(tempOnlineUser);
        }

        User classmate = user.matchUser(onlineUsersList);
        System.out.println(classmate.getUsername());
    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void pauseMedia(ActionEvent event) {

    }

    @FXML
    void playMedia(ActionEvent event) {

    }

    @FXML
    void resetMedia(ActionEvent event) {

    }

}
