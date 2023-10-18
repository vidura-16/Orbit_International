package com.example.international;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    @FXML
    private TextField txtUsernameLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private Button loginButton;

    @FXML
    private Button manager;

    @FXML
    private Label namelabel;

    @FXML
    private Button forgotPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtNIC;

    @FXML
    private Button ConfirmButton;

    @FXML
    private Label alertLabel;

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

    public void loginButtonOnAction(ActionEvent event){
       loginMessageLabel.setText("Please enter valid username and password!");
        AnnouncemnetDelete();
        if(txtUsernameLogin.getText().isBlank() == false && txtPassword.getText().isBlank() == false) {
            validateLogin();

        }else if(txtUsernameLogin.getText().isBlank() == true){
            loginMessageLabel.setText("Please enter your username");

        }else if(txtPassword.getText().isBlank() == true){
            loginMessageLabel.setText("Please enter your password");

        }else {
            loginMessageLabel.setText("Please enter valid username and password");
        }

    }



    @FXML
    public void manager(ActionEvent event) throws IOException {
        String name = txtUsernameLogin.getText();
        namelabel.setText(name);

        Parent root=FXMLLoader.load(getClass().getResource("ManagerDashBoard.fxml"));
        Stage window= (Stage) manager.getScene().getWindow();
        window.setScene(new Scene(root,900,700));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
        usernamePasstoDB();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void validateLogin() {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectionDB = connectNow.getConnection();

        String verifyLogin = "SELECT * FROM `employee` WHERE `username` = '" + txtUsernameLogin.getText() +
                "' AND `password` = '" + txtPassword.getText() + "' ";

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            String manager = "Manager";
            String senior = "Senior Employee";
            String employee = "Employee";

            while (queryResult.next()) {
                String status = queryResult.getString("status");

                if (queryResult.getInt(1) > 0 && status.equalsIgnoreCase(manager)) {
                    loginToManager();

                } else if(queryResult.getInt(1) > 0 && status.equalsIgnoreCase(senior)){
                    LoginToSenior();

                }else if(queryResult.getInt(1) > 0 && status.equalsIgnoreCase(employee)){
                    LoginToEmployee();

                }else {
                    loginMessageLabel.setText("Invalid login, Please try again");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }



    public void forgotPassword(ActionEvent event) {
        loginMessageLabel.setText("Please enter valid Username");
        if(txtUsernameLogin.getText().isBlank() == false){
            userNameValidation();

        }else {
            loginMessageLabel.setText("Please enter valid username");
        }

    }

    public String userNameValidation(){

            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectionDB = connectNow.getConnection();

            String verifyLogin = "SELECT * FROM `employee` WHERE `username` = '" + txtUsernameLogin.getText() + "' ";

            try {
                Statement statement = connectionDB.createStatement();
                ResultSet queryResult = statement.executeQuery(verifyLogin);

                while (queryResult.next()) {
                    FXMLLoader loader= new FXMLLoader(getClass().getResource("ForgotPassword.fxml"));
                    Parent root = (Parent) loader.load();

                    ForgotPasswordController forgotPasswordController = loader.getController();
                    forgotPasswordController.Username(txtUsernameLogin.getText());
                    Stage stage=new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();

                    stage = (Stage) loginButton.getScene().getWindow();
                    stage.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }

        return verifyLogin;
    }

    //for manager dashboard

    public void usernamePasstoDB() throws IOException
    {
        Connect();
        String UsernameDB= txtUsernameLogin.getText();
        try {
            pst = c.prepareStatement("insert into activity(username)values (?)");
            pst.setString(1, UsernameDB);
            int status = pst.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void loginToManager() throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ManagerDashboard.fxml"));
        primaryStage.setTitle("Manager");
        primaryStage.setScene(new Scene(root,1400,767));
        primaryStage.show();
        usernamePasstoDB();

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setTitle("");

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
    }


    public void ClearField(javafx.scene.input.MouseEvent mouseEvent){
        loginMessageLabel.setText("");
    }

    public void LoginToSenior() throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("seniorEmployeeDash.fxml"));
        primaryStage.setTitle("Senior Employee");
        primaryStage.setScene(new Scene(root,1400,767));
        primaryStage.show();
        usernamePasstoDB();

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setTitle("");

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
    }

    public void LoginToEmployee() throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeDash.fxml"));
        primaryStage.setTitle("Employee");
        primaryStage.setScene(new Scene(root,1400,767));
        primaryStage.show();
        usernamePasstoDB();

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setTitle("");

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
    }

    //auto delete announcement
    public void AnnouncemnetDelete(){
        try{
            Connect();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String dateNtime = dtf.format(now);
            String date = dateNtime.substring(0,10);
            System.out.println(date);

          String sql = "DELETE FROM announcement WHERE `announcement`.`date`='"+date+"' ";

            pst = c.prepareStatement(sql);
            pst.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

