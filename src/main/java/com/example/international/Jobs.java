package com.example.international;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Jobs implements Initializable {

    @FXML
    private ChoiceBox<String> country;
    private String[] Country= {"Saudi Arabia","Oman","Qatar","UAE","Kuwait","Bahrain"};

    @FXML
    private ChoiceBox<String> experience;
    private String[] Experience= {"Less than 1 year","1 year Experience","2 year Experience","3 year experience","4 year experience","5 year experience","More than 5 years"};

    @FXML
    private ChoiceBox<String> gender;
    private String[] Gender={"Male","Female"};

    @FXML
    private ChoiceBox<String> period;
    private String[] Period= {"One Year","Two Years","Three years"};

    @FXML
    private TextField salary;

    @FXML
    private ChoiceBox<String> age;
    private String[] Age= {"Below Thirty","Below Fourty","Below Fifty"};

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtSponsor;

    @FXML
    private TextField txtvisa;
    @FXML
    private TextField txtmail;

    @FXML
    private ChoiceBox<String> title;
    private String[] Title= {"Cheff","Cooking","Cleaners","Co-Worker","Driving","House maids","Janitor","Security","Shop keeper","Heavy Vehicle Driving","Waiters","Technician"};

    @FXML
    private ChoiceBox<String> status;
    private String[] Status= {"Available","Completed"};

    @FXML
    private Button btnDash;

    @FXML
    private Button btnAddEmployee;

    @FXML
    private Button btnViewEmployee;

    @FXML
    private Button btnAddApplicant;

    @FXML
    private Button btnViewApplicant;

    @FXML
    private Button btnleaveRequest;

    @FXML
    private Button btnAnnouncement;

    @FXML
    private Button btnMails;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnAddtask;

    @FXML
    private Button btnJobs;

    @FXML
    void LeaveRequest(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("LeaveRequest.fxml"));
        Stage window= (Stage) btnleaveRequest.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void addEmployee(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
        Stage window= (Stage) btnAddEmployee.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void addTask(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("AddTaskM.fxml"));
        Stage window= (Stage) btnAddtask.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void dashboard(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("ManagerDashBoard.fxml"));
        Stage window= (Stage) btnDash.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void onActionAddApplicant(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("ApplicantManager.fxml"));
        Stage window= (Stage) btnAddApplicant.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void onActionAnnouncement(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("announcement1.fxml"));
        Stage window= (Stage) btnAnnouncement.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void viewApplicant(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("viewAllApplicants.fxml"));
        Stage window= (Stage) btnViewApplicant.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void viewEmployee(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("ViewEmployee.fxml"));
        Stage window= (Stage) btnViewEmployee.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void viewJobs(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("Jobs.fxml"));
        Stage window= (Stage) btnJobs.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void viewMails(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("email.fxml"));
        Stage window= (Stage) btnMails.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }
    Connection c;
    PreparedStatement pst;

    @FXML
    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost/orbit", "root", "");
            System.out.println("Connection succeed");
        } catch (ClassNotFoundException | SQLException var2) {
            var2.printStackTrace();
            System.out.println("Connection failed");
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        title.getItems().addAll(Title);
        country.getItems().addAll(Country);
        age.getItems().addAll(Age);
        gender.getItems().addAll(Gender);
        period.getItems().addAll(Period);
        experience.getItems().addAll(Experience);
        status.getItems().addAll(Status);

    }

    @FXML
    public void Addjob() {
        this.Connect();


        String val1=this.txtvisa.getText();
        String val2=this.txtSponsor.getText();
        String val3=this.txtmail.getText();
        String val4=this.txtPrice.getText();
        String val5=this.title.getValue();
        String val6=this.country.getValue();
        String val7=this.gender.getValue();
        String val8=this.age.getValue();
        String val9=this.period.getValue();
        String val10=this.experience.getValue();
        String val11=this.salary.getText();
        String val12=this.status.getValue();


        try{
            this.pst = this.c.prepareStatement("insert into jobs(NoOfVisa,sponsor,mail,price,title,country,gender,age,period,experience,salary,status)values(?,?,?,?,?,?,?,?,?,?,?,?)");

            this.pst.setString(1, val1);
            this.pst.setString(2, val2);
            this.pst.setString(3, val3);
            this.pst.setString(4, val4);
            this.pst.setString(5, val5);
            this.pst.setString(6, val6);
            this.pst.setString(7, val7);
            this.pst.setString(8, val8);
            this.pst.setString(9, val9);
            this.pst.setString(10, val10);
            this.pst.setString(11, val11);
            this.pst.setString(12, val12);

            int Status = pst.executeUpdate();
            if (Status == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Confirm");
                alert.setHeaderText("Member");
                alert.setContentText("Are you sure you want to save record?");
                alert.showAndWait();
                txtvisa.setText("");
                txtSponsor.setText("");
                txtmail.setText("");
                txtPrice.setText("");
                title.setValue(null);
                country.setValue(null);
                gender.setValue(null);
                age.setValue(null);;
                period.setValue(null);
                experience.setValue(null);
                status.setValue(null);
                salary.setText("");

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error Message");
            alert.setHeaderText("Member");
            alert.setContentText("Failed");
            alert.showAndWait();

        }



    }catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @FXML
    void Logout(ActionEvent event) throws IOException, SQLException {
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


}


