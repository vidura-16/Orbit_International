package com.example.international;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class emailController implements Initializable {

    public TextField txtEmail;

    public TextField txtSubject;

    public TextArea txtMessage;

    public Button sendButton;

    public Label sendBoolValue;

    @FXML
    private TextField searchBar;

    @FXML
    private Label InvalidLabel;

    @FXML
    private TableView<data_email> table;

    @FXML
    private TableColumn<data_email, String> applicantNameCol;

    @FXML
    private TableColumn<data_email, String> lastnameCol;

    @FXML
    private TableColumn<data_email, String> emailCol;

    @FXML
    private Label countLabel;

    @FXML
    private Label sendMail;

    @FXML
    private Button clearButton;

    @FXML
    private Button refreshButton;

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
    void LeaveRequest(ActionEvent event) throws IOException {
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


    int index = -1;

    //database connection
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


    public void buttonClicked(ActionEvent actionEvent) {
        sendEmail();
    }

    public void sendEmail() {
        if(txtEmail.getText().isEmpty() == false && txtSubject.getText().isEmpty() == false && txtMessage.getText().isEmpty() == false ){
            InvalidLabel.setText("");
            String to = txtEmail.getText();
            String host = "smtp.gmail.com";
            String username = "OrbitInternational012@gmail.com";
            String password = "Orbit123@";

        //setup mail server
            Properties props = System.getProperties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");

            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });


        try {
            //create mail
            MimeMessage m = new MimeMessage(session);
            m.setFrom(new InternetAddress(username));
            m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            m.setSubject(txtSubject.getText());
            m.setText(txtMessage.getText());

            //send mail
            Transport.send(m);
            sendBoolValue.setVisible(true);
            System.out.println("Email send to "+to);
            sendMail.setText(to);
            Connect();
            String status = "yes";
            String sql = "update applicant set emailStat='"+status+"' where email='"+sendMail.getText()+"' ";
            pst = c.prepareStatement(sql);
            pst.execute();
            txtMessage.setText("");
            txtEmail.setText("");
            txtSubject.setText("");

        } catch (MessagingException | SQLException e) {
            e.printStackTrace();
        }
            }else {
            InvalidLabel.setText("Please fill all the fields!");
        }

    }


    //view data in table
    ObservableList<data_email> records = FXCollections.observableArrayList();

    public void tableEmail() {
        ObservableList<data_email> records = FXCollections.observableArrayList();
        try {
            pst = c.prepareStatement("select Fname,Lname,email from applicant where `status` ='assigned' AND `emailStat` ='no'");
            ResultSet rs = pst.executeQuery();
            {
                int count = 0;
                while (rs.next()) {
                    data_email record = new data_email();
                    record.setFname(rs.getString("Fname"));
                    record.setLname(rs.getString("Lname"));
                    record.setemail(rs.getString("email"));
                    records.add(record);
                    count++;
                    countLabel.setText(String.valueOf("("+count+")"));

                }
            }
            table.setItems(records);
            applicantNameCol.setCellValueFactory(f -> f.getValue().FnameProperty());
            lastnameCol.setCellValueFactory(f -> f.getValue().LnameProperty());
            emailCol.setCellValueFactory(f -> f.getValue().emailProperty());


        } catch (SQLException ex) {
            Logger.getLogger(AnnouncementController.class.getName()).log(Level.SEVERE, null, ex);
        }


        FilteredList<data_email> filteredData = new FilteredList<>(records, b-> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(data -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (data.getFname().toLowerCase().indexOf(searchKeyword) > -1 ) {
                    return true;
                }else if (data.getLname().toLowerCase().indexOf(searchKeyword) > -1 ){
                        return true;
                }else {
                    return false;
                }
            });

        });

        SortedList<data_email> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    public void selectRow(javafx.scene.input.MouseEvent mouseEvent) {
        index = table.getSelectionModel().getFocusedIndex();
        if(index <= -1){
            return;
        }
        txtEmail.setText(emailCol.getCellData(index).toString());


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



    public void RefreshTable(ActionEvent actionEvent) throws SQLException {
        records.clear();

        try {
            pst = c.prepareStatement("select Fname,Lname,email from applicant where `status` ='Assigned' AND `emailStat` ='no'");
            ResultSet rs = pst.executeQuery();
            {
                int count = 0;
                while (rs.next()) {
                    data_email record = new data_email();
                    record.setFname(rs.getString("Fname"));
                    record.setLname(rs.getString("Lname"));
                    record.setemail(rs.getString("email"));
                    records.add(record);
                    count++;
                    countLabel.setText(String.valueOf("("+count+")"));
                }
            }
            table.setItems(records);
            applicantNameCol.setCellValueFactory(f -> f.getValue().FnameProperty());
            lastnameCol.setCellValueFactory(f -> f.getValue().LnameProperty());
            emailCol.setCellValueFactory(f -> f.getValue().emailProperty());

        } catch (SQLException ex) {
            Logger.getLogger(AnnouncementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void assignedButton(ActionEvent actionEvent) throws SQLException {

        txtSubject.setText("We found the best Job for you!");

        String SendEmail = txtEmail.getText();
        pst = c.prepareStatement("select Fname,Lname,email from applicant where `email` ='"+SendEmail+"'");
        ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String FirstName = rs.getString("Fname");
                String LastName = rs.getString("Lname");

                sendMail.setText("Dear "+FirstName+" "+LastName+",\n\n");
            }

        txtMessage.setText(sendMail.getText()+"While you are registered with us, we found the best choice for you. The job requirements are matching with your details. So without holding, we reserved the job for you. We will inform you of all details shortly.\n\nThank You\nOrbit International Pvt(Ltd.)");
    }

    @FXML
    void AssignedInvalidButton(ActionEvent event) throws SQLException {
        txtSubject.setText("We are sorry to inform you!");

        String SendEmail = txtEmail.getText();
        pst = c.prepareStatement("select Fname,Lname,email from applicant where `email` ='"+SendEmail+"'");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String FirstName = rs.getString("Fname");
            String LastName = rs.getString("Lname");

            sendMail.setText("Dear "+FirstName+" "+LastName+",\n\n");
        }

        txtMessage.setText(sendMail.getText()+"While you Assigned to a job, we found there were some issues. We do our best to clear all the problems ASAP. After resolving all of them, we will get back to you.\n\nThank You\nOrbit International Pvt(Ltd.)");
    }

    public void medicalReportInvalid(ActionEvent event) throws SQLException {
        txtSubject.setText("We found your Medical report is Invalid!");

        String SendEmail = txtEmail.getText();
        pst = c.prepareStatement("select Fname,Lname,email from applicant where `email` ='"+SendEmail+"'");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String FirstName = rs.getString("Fname");
            String LastName = rs.getString("Lname");

            sendMail.setText("Dear "+FirstName+" "+LastName+",\n\n");
        }

        txtMessage.setText(sendMail.getText()+"After checking your medical report, we found some issues with it. Please check your Medical Report and get back to us ASAP. \n\nMake sure that the medical report is:\n• Given by recognized and recommended health care centers.\n" +
                "• Ensure the Medical Report is not expired.\n\nThank You\nOrbit International Pvt(Ltd.)");
    }

    public void medicalReportExpired(ActionEvent event) throws SQLException {
        txtSubject.setText("We found your Medical report is Expired!");

        String SendEmail = txtEmail.getText();
        pst = c.prepareStatement("select Fname,Lname,email from applicant where `email` ='"+SendEmail+"'");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String FirstName = rs.getString("Fname");
            String LastName = rs.getString("Lname");

            sendMail.setText("Dear "+FirstName+" "+LastName+",\n\n");
        }

        txtMessage.setText(sendMail.getText()+"After checking your medical report, we found your Medical Report is Expired. Please check your Medical Report and get back to us ASAP. \n\nMake sure that the medical report is:\n• Given by recognized and recommended health care centers.\n" +
                "• Ensure the Medical Report is not expired.\n\nThank You\nOrbit International Pvt(Ltd.)");
    }

    public void ClearField(javafx.scene.input.MouseEvent mouseEvent){
        InvalidLabel.setText("");
    }

    public void ClearAll(ActionEvent event) {
        txtMessage.setText("");
        txtEmail.setText("");
        txtSubject.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connect();
        tableEmail();

    }

}