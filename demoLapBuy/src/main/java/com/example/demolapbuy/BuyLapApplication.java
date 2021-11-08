package com.example.demolapbuy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyLapApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BuyLapApplication.class.getResource("buylap-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 375, 780);
        stage.setTitle("BuyLap");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}