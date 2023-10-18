package com.example.international;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDashController {
    @FXML
    private Label date;

    @FXML
    private Label unameLabel;

    @FXML
    private Label time;

    @FXML
    private Button btnAddApplicant;

    @FXML
    private Button btnTodo;

    @FXML
    private Button btnViewApplicant;

    @FXML
    private Button btnAlerts;

    @FXML
    private Button btnLeaveRequests;




    @FXML
    private Label labelName;

    @FXML
    private ImageView profilePicView;

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



    private int minute;
    private int hour;
    private int second;
    int Date;
    int month;
    int year;
    private volatile boolean stop = false;


    private void timeNow(){
        Thread thread=new Thread(() ->{
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss a");
            Calendar cal = Calendar.getInstance();
            while (!stop){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println(e);

                }
                final String timenow= sdf.format(new Date());
                Platform.runLater(() ->{
                    time.setText(timenow);
                    Date=cal.get(Calendar.DATE);
                    month=cal.get(Calendar.MONTH);
                    year=cal.get(Calendar.YEAR);
                    date.setText(Date+" / "+month+" / "+year);
                });
            }
        });
        thread.start();
    }

    @FXML
    void OnActionAddApplicant(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("ApplicantEmployee.fxml"));
        Stage window= (Stage) btnAddApplicant.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));

        //full screen
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void OnActionLeaveRequests(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("ApplyLeaveEmployee.fxml"));
        Stage window= (Stage) btnLeaveRequests.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));

        //full Screen
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }


    @FXML
    void OnActionViewApplicant(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("viewAllApplicantsEmployee.fxml"));
        Stage window= (Stage) btnViewApplicant.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));
        window.setTitle("View Applicants");

        //full Screen
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }


    @FXML
    void ViewAlert(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Alert-Employee.fxml"));
        Stage window= (Stage) btnAlerts.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));

        //full screen
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void viewTodoList(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("ViewTaskEmployee.fxml"));
        Stage window= (Stage) btnTodo.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));

        //full screen
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }
    @FXML
    private Button btnLogout;

    @FXML
    void Logout(ActionEvent event) throws IOException {

        String sql = "delete from activity";
        try {
            Connect();
            pst = c.prepareStatement(sql);
            int i = pst.executeUpdate();
            Stage stage = (Stage) btnLogout.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            primaryStage.setTitle("Manager");
            primaryStage.setScene(new Scene(root,900,600));
            primaryStage.show();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    @FXML
    void initialize() {
        timeNow();
        NamePass();
        AlertCount();
    }

    @FXML
    private void ViewProfile() throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("UserProfile.fxml"));
        Parent root = (Parent) loader.load();

        UserProfileController userProfileController = loader.getController();
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }



    public void NamePass(){
        try{
            Connect();
            ResultSet rs1 = c.createStatement().executeQuery("select * from activity ORDER BY ActivityID DESC");
            if(rs1.next()) {
                String UserNamePass =rs1.getString("username");
                System.out.println(UserNamePass);
                ResultSet rs = c.createStatement().executeQuery("select firstName,lastName,profilePicture from employee where " +
                        "username = '"+UserNamePass+"'");

                if(rs.next()) {
                    String firstName =rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    labelName.setText(firstName+" "+lastName);
                    Blob blob = rs.getBlob(3);
                    InputStream inputStream = blob.getBinaryStream();
                    Image image = new Image(inputStream);
                    profilePicView.setImage(image);
                }

            }
        }catch(Exception e){

        }
    }

    @FXML
    private Label AlertCountLabel;

    public void AlertCount() {
        Connect();
        try {
            pst = c.prepareStatement("select announcement,date,visibility,topic from announcement where `visibility` IN('Only for Employee','For All') ");
            ResultSet rs = pst.executeQuery();
            {
                int count = 0;
                while (rs.next()) {

                    count++;
                    AlertCountLabel.setText(String.valueOf(count));

                }
            }


        } catch (SQLException ex) {
            Logger.getLogger(AnnouncementController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
