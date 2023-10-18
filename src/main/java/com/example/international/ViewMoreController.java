package com.example.international;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.ResourceBundle;

public class ViewMoreController implements Initializable {

    @FXML
    private Label noteLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label topicLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void viewMore(String txtTopicText, String text, String topicText){

        dateLabel.setText(topicText);
        topicLabel.setText(txtTopicText);
        noteLabel.setText(text);

    }

}
