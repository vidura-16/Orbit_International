package com.example.international;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ForgotPasswordController implements Initializable {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtNIC;

    @FXML
    private Label alertLabel;

    @FXML
    private Button confirmButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void Username(String text){
        txtUsername.setText(text);
    }

    public void ConfirmButtonOnAction(ActionEvent event) throws IOException {
        alertLabel.setText("Please enter correct details!");
        if(txtUsername.getText().isBlank() == false && txtFirstName.getText().isBlank() == false && txtLastName.getText().isBlank() == false && txtNIC.getText().isBlank() == false){

            ValidateUser();
        }else {
            alertLabel.setText("Please enter correct details");
        }

    }



    public void ValidateUser() {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectionDB = connectNow.getConnection();

        String username = txtUsername.getText();

        String verifyUser = "SELECT * FROM `employee` WHERE `username` = '" + username + "' AND `firstName` = '" + txtFirstName.getText() + "' AND `lastName` = '" + txtLastName.getText() + "' AND `nic` = '" + txtNIC.getText() + "'";

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyUser);

            while (queryResult.next()) {
                if (queryResult.getInt(1) > 0 ) {
                    try {
                        FXMLLoader loader= new FXMLLoader(getClass().getResource("resetPassword.fxml"));
                        Parent root = (Parent) loader.load();

                        resetPasswordController reController = loader.getController();
                        reController.myFunction(txtUsername.getText());
                        Stage stage=new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();

                        stage = (Stage) confirmButton.getScene().getWindow();
                        stage.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    alertLabel.setText("");
                }else {
                    alertLabel.setText("Please fill all the Fields!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void ClearField(javafx.scene.input.MouseEvent mouseEvent){
        alertLabel.setText("");
    }


}
