package com.example.demolapbuy;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button signup;
    @FXML
    public void switchSignUp(ActionEvent event) throws IOException {

        Parent SignUpView  = FXMLLoader.load(getClass().getResource("signup-view.fxml"));
        Scene sceneSignUp= new Scene(SignUpView);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneSignUp);
        window.show();
    }

    @FXML
    protected void onSingInClick() {

    }

    @FXML
    protected void onSkipClick() {

    }
}