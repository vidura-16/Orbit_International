package com.example.international;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class UserProfileController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label positionLabel;

    @FXML
    private ImageView imageLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label contactLabel;

    @FXML
    private Label dateJoinLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label salaryLabel;

    @FXML
    private Label nicLabel;

    @FXML
    private Label dobLabel;

    @FXML
    private Label genderLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField nametext;

    @FXML
    private PasswordField txtOldPassword;

    @FXML
    private PasswordField txtNewPassword;

    @FXML
    private PasswordField txtPasswordConfirm;

    @FXML
    private Label labelOldPassword;

    @FXML
    private Label labelNewPassword;

    @FXML
    private Label labelNewPasswordConfirm;

    @FXML
    private Button BTN;

    Connection c;
    PreparedStatement pst;

    public Connection Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orbit", "root", "");
            System.out.println("Connection succeed");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }
        return null;
    }

    @FXML
    private Label labelUserProfilePass;

    public void userprofilePass(){
        try {
            Connect();
            ResultSet rs1 = c.createStatement().executeQuery("select * from activity");
            if(rs1.next()) {
                String UserNamePass = rs1.getString("username");
                ResultSet rs = c.createStatement().executeQuery("select firstname,lastName,status,profilepicture,email,telephoneNum,dateofJoin," +
                        "address,salary,nic,dob,gender,username,password " +
                        "from employee where username = '" + UserNamePass + "'");
                if (rs.next()) {
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    nameLabel.setText(firstName + " " + lastName);
                    positionLabel.setText(rs.getString(3));
                    Blob blob = rs.getBlob(4);
                    InputStream inputStream = blob.getBinaryStream();
                    Image image = new Image(inputStream);
                    imageLabel.setImage(image);
                    emailLabel.setText(rs.getString(5));
                    contactLabel.setText(rs.getString(6));
                    dateJoinLabel.setText(rs.getString(7));
                    addressLabel.setText(rs.getString(8));
                    salaryLabel.setText(rs.getString(9));
                    nicLabel.setText(rs.getString(10));
                    dobLabel.setText(rs.getString(11));
                    genderLabel.setText(rs.getString(12));
                    usernameLabel.setText(rs.getString(13));
                    if (txtOldPassword.getText() == (rs.getString(14))) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText("Employee");
                        alert.setContentText("Employee Details Added Successfully");
                        alert.showAndWait();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void passwordChangeSave(ActionEvent event) {
        try {
            Connect();
            ResultSet rs1 = c.createStatement().executeQuery("select * from activity");
            if(rs1.next()) {
                String UserNamePass = rs1.getString("username");
                ResultSet rs = c.createStatement().executeQuery("select password from employee where username = '" + UserNamePass + "'");
                if (rs.next()) {
                    validate();
                    if (txtOldPassword.getText().matches(rs.getString(1))) {
                        labelOldPassword.setText("");
                        if (txtNewPassword.getText().isEmpty() && txtPasswordConfirm.getText().isEmpty()) {
                            labelNewPassword.setText("Please enter a correct new password.");
                        } else if (txtNewPassword.getText().matches(txtPasswordConfirm.getText())) {
                            labelNewPassword.setText("");
                            labelNewPasswordConfirm.setText("");
                            String value1 = txtNewPassword.getText();
                            String sql = "update employee set password='" + value1 + "' where username = '" + UserNamePass + "'";
                            pst = c.prepareStatement(sql);
                            int a = pst.executeUpdate();
                            if (a == 1) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Success");
                                alert.setHeaderText("Password Change");
                                alert.setContentText("Password Changes Successfully");
                                alert.showAndWait();
                                clear();
                            }
                        } else {
                            labelNewPassword.setText("");
                            labelNewPasswordConfirm.setText("Passwords doesn't match.");
                        }
                    } else {
                        labelOldPassword.setText("Please enter a correct old password");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void CancelPassword(ActionEvent event) {
        clear();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Password Change");
        alert.setContentText("Password Change Cancelled.");
        alert.showAndWait();
    }

    public void clear() {
        txtOldPassword.setText("");
        txtNewPassword.setText("");
        txtPasswordConfirm.setText("");
        labelOldPassword.setText("");
        labelNewPassword.setText("");
        labelNewPasswordConfirm.setText("");
    }

    public void validate() {
        if(txtOldPassword.getText().isEmpty()) {
            labelOldPassword.setText("Please enter a correct old password.");
        }
        if(txtNewPassword.getText().isEmpty()){
            labelNewPassword.setText("Please enter a correct new password.");
        }
        if(txtPasswordConfirm.getText().isEmpty()){
            labelNewPasswordConfirm.setText("Please enter the new password again.");
        }
    }
    @FXML
    void initialize() throws IOException {
        userprofilePass();
    }
}