package com.example.international;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class     SplashUIController implements Initializable {

    @FXML
    private AnchorPane slashParent;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        FadeTransition.applyFadeTransition(slashParent, Duration.seconds(5), (e) ->{
            try {
                Parent fxml = FXMLLoader.load(getClass().getResource("login.fxml"));
                slashParent.getChildren().removeAll();
                slashParent.getChildren().setAll(fxml);
            } catch (IOException ex) {
                Logger.getLogger(SplashUIController.class.getName()).log(Level.SEVERE, null,ex);
            }

        });
    }
}

