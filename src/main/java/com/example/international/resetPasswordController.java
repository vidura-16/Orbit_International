package com.example.international;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class resetPasswordController implements Initializable {

    @FXML
    private PasswordField txtNewPassword;

    @FXML
    private PasswordField txtConfirmNewPassword;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private Label usernamelabel;

    @FXML
    private Label value;

    @FXML
    private Button changePasswordButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void myFunction(String text){
        usernamelabel.setText(text);
    }

    int index = -1;
    Connection c;
    PreparedStatement pst;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orbit", "root", "");
            System.out.println("Connection succeed");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }
    }

    public void ConfirmPasswordButtonOnAction(ActionEvent event){

        String newPassword = txtNewPassword.getText();
        String ConfirmPassword = txtConfirmNewPassword.getText();
        int length = newPassword.length();

        if(newPassword.isBlank() == false && ConfirmPassword.isBlank() == false && newPassword.equals(ConfirmPassword) ){
           if (length > 6){
               confirmPassword();
           }else{
               loginMessageLabel.setText("Please enter password longer than 6 characters");
           }

        }else {
            loginMessageLabel.setText("Please enter same password");
            txtConfirmNewPassword.setStyle("-fx-border-color:red ; -fx-border-width: 2px");
        }

    }

    //String username = usernamelabel.getText();

    public void PassData(javafx.scene.input.MouseEvent mouseEvent){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectionDB = connectNow.getConnection();

        String verifyLogin = "SELECT * FROM `employee` WHERE `username` = '" + usernamelabel.getText() + "' ";

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                //int id = queryResult.getInt("EmpID");
                //usernamelabel.setText(String.valueOf(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void confirmPassword() {

        try{
            Connect();

                String sql = "UPDATE `employee` SET `password` = '" + txtNewPassword.getText() + "' WHERE `employee`.`username` = '" + usernamelabel.getText() + "'";

                pst = c.prepareStatement(sql);
                pst.execute();

                loginMessageLabel.setText("");
                txtNewPassword.setText("");
                txtConfirmNewPassword.setText("");
            txtNewPassword.setStyle("-fx-border-color: transparent; ");
            txtConfirmNewPassword.setStyle("-fx-border-color: transparent; ");
            strengthLabel.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Change Password");
                alert.setHeaderText("Change Password");
                alert.setContentText("Password changed Successfully");
                alert.showAndWait();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Password changed");
            alert.setHeaderText("Password changed");
            alert.setContentText("Wait a Minutes");
            alert.showAndWait();
                sendEmail();
                LoginPage();


        }catch (Exception e){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Change Password");
            alert.setHeaderText("Change Password");
            alert.setContentText("Password changed failed");
            alert.showAndWait();
            txtNewPassword.setText("");
            txtConfirmNewPassword.setText("");

        }

    }



    //to send email to inform the password was changed
    public void sendEmail(){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectionDB = connectNow.getConnection();

        String verifyLogin = "SELECT * FROM `employee` WHERE `username` = '" + usernamelabel.getText() + "' ";

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                int id = queryResult.getInt("EmpID");
                String email = queryResult.getString("email");
                String fName = queryResult.getString("firstName");
                String lName = queryResult.getString("lastName");
                String user = queryResult.getString("username");

                String to = email;
                String host = "smtp.gmail.com";
                String username = "orbitinternational7@gmail.com";
                String password = "Orbit123@";
                String subject = "You've got yourself a new password.";
                String message = "Hi "+fName+" "+lName+", \n \n \n Your password for username '"+user+"' successfully changed.\n \n If this was you, you can safely ignore this email.";

                //setup mail server
                Properties props = System.getProperties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                props.put("mail.smtp.ssl.protocols", "TLSv1.2");

                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(username,password);
                    }
                });

                try{
                    //create mail
                    MimeMessage m = new MimeMessage(session);
                    m.setFrom(new InternetAddress(username));
                    m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
                    m.setSubject(subject);
                    m.setText(message);

                    //send mail
                    Transport.send(m);
                    value.setVisible(true);
                    System.out.println("Email send!");

                }catch(MessagingException e){
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }



    }


    public void LoginPage() throws IOException {
        Stage stage = (Stage) changePasswordButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root,900,600));
        primaryStage.show();
    }

    @FXML
    private Label strengthLabel;
    public void passwordStrong(javafx.scene.input.KeyEvent keyEvent) {
        String passw = txtNewPassword.getText();
        int length = passw.length();
        System.out.println(length);

        if(length <= 6){
            txtNewPassword.setStyle("-fx-border-color: red; -fx-border-width: 2px");
            strengthLabel.setText("Password Strength: Bad");
        }else if(length == 7){
            txtNewPassword.setStyle("-fx-border-color: orange; -fx-border-width: 2px");
            strengthLabel.setText("Password Strength: Medium");
        }else if(length > 7){
            txtNewPassword.setStyle("-fx-border-color:green ; -fx-border-width: 2px");
            strengthLabel.setText("Password Strength: Strong");
        }else if(length >= 9){
            txtNewPassword.setStyle("-fx-border-color:green ; -fx-border-width: 2px");
            strengthLabel.setText("Password Strength: Strong");
        }else{
            txtNewPassword.setStyle("-fx-border-color: red; -fx-border-width: 2px");
            strengthLabel.setText("Password Strength: Bad");
        }

    }

}
