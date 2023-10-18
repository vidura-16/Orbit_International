package com.example.international;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Stage stage = null;

    public static void main(String[] args) {
        Application.launch(args);
    }


    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SplashUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Image img=new Image(getClass().getResourceAsStream("/com/example/international/images/splashscreen.jpg"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(img);
        stage.show();
        this.stage = stage;


    }
}