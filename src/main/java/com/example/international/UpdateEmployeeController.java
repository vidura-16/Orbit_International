package com.example.international;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployeeController {

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtContact;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtSalary;


    Connection c;
    PreparedStatement pst;

    public void Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orbit", "root", "");
            System.out.println("Connection succeed");
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Connection failed");
        }
    }

    public void EmployeeData(){

    }

}
