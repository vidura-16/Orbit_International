package com.example.international;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManagerDashController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button btnAddApplicant;

        @FXML
        private Button btnAddEmployee;

        @FXML
        private Button btnAddTask;

        @FXML
        private Button btnAddVaccancy;

        @FXML
        private Button btnAnnouncements;

        @FXML
        private Button btnApplicantReport;

        @FXML
        private Button btnLeaveRequests;

        @FXML
        private Button btnMails;

        @FXML
        private Button btnMonthlyReport;

        @FXML
        private Button btnSalary;

        @FXML
        private Button btnSpomsorReport;

        @FXML
        private Button btnViewApplicant;

        @FXML
        private Button btnViewEmployee;

        @FXML
        private Label Unamelabel;

        @FXML
        private Label labelName;

        @FXML
        private ImageView profilePicView;

        @FXML
        private Label date;

        @FXML
        private Label time;

        @FXML
        private Button btnLogout;

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

        @FXML
        void OnActionAddApplicant(ActionEvent event) throws IOException{
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
        void OnActionAddEmployee(ActionEvent event) throws IOException{
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
        void OnActionAddTask(ActionEvent event) throws IOException{
                Parent root=FXMLLoader.load(getClass().getResource("AddTaskM.fxml"));
                Stage window= (Stage) btnAddTask.getScene().getWindow();
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
        void OnActionAnnouncements(ActionEvent event) throws IOException{
                Parent root=FXMLLoader.load(getClass().getResource("announcement1.fxml"));
                Stage window= (Stage) btnAnnouncements.getScene().getWindow();
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
        void OnActionLeaveRequests(ActionEvent event) throws IOException{
                Parent root=FXMLLoader.load(getClass().getResource("LeaveRequest.fxml"));
                Stage window= (Stage) btnLeaveRequests.getScene().getWindow();
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
        void OnActionMails(ActionEvent event) throws IOException{
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

        @FXML
        void OnActionSalary(ActionEvent event) throws IOException{
                Parent root=FXMLLoader.load(getClass().getResource("Salary_slip.fxml"));
                Stage window= (Stage) btnSalary.getScene().getWindow();
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
        void OnActionViewApplicant(ActionEvent event) throws IOException{
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
        void OnActionViewEmployee(ActionEvent event) throws IOException{
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
        void OnActionbtnAddVaccancy(ActionEvent event) throws IOException {
                Parent root=FXMLLoader.load(getClass().getResource("Jobs.fxml"));
                Stage window= (Stage) btnAddVaccancy.getScene().getWindow();
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
        void OnActionApplicantReport(ActionEvent event) throws IOException {
                Task<Void> task = new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                                HashMap parameters = new HashMap();
                                JasperPrint jp = JasperFillManager.fillReport("report/ApplicantReport.jasper",parameters,JDBConnector.getConnection());
                                JasperViewer viewer = new JasperViewer(jp,false);
                                viewer.setVisible(true);
                                return null;
                        }
                };
                ExecutorService service = Executors.newCachedThreadPool();
                service.execute(task);
                service.shutdown();
        }

        @FXML
        void OnActionMonthlyReport(ActionEvent event) {
                Task<Void> task = new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                                HashMap parameters = new HashMap();
                                JasperPrint jp = JasperFillManager.fillReport("report/EmpFullReport.jasper",parameters,JDBConnector.getConnection());
                                JasperViewer viewer = new JasperViewer(jp,false);
                                viewer.setVisible(true);
                                return null;
                        }
                };
                ExecutorService service = Executors.newCachedThreadPool();
                service.execute(task);
                service.shutdown();
        }

        @FXML
        void OnActionSponsorReport(ActionEvent event) {
                Task<Void> task = new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                                HashMap parameters = new HashMap();
                                JasperPrint jp = JasperFillManager.fillReport("report/Sponsor_Report.jasper",parameters,JDBConnector.getConnection());
                                JasperViewer viewer = new JasperViewer(jp,false);
                                viewer.setVisible(true);
                                return null;
                        }
                };
                ExecutorService service = Executors.newCachedThreadPool();
                service.execute(task);
                service.shutdown();
        }


        @FXML
        void initialize() {
                timeNow();
                NamePass();
                NamePass();
        }

        public void ViewProfile(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
                FXMLLoader loader= new FXMLLoader(getClass().getResource("UserProfile.fxml"));
                Parent root = (Parent) loader.load();

                UserProfileController userProfileController = loader.getController();
                Stage stage=new Stage();
                stage.setScene(new Scene(root));
                stage.show();
       }

        public void NamePass() {
                try {
                        Connect();
                        ResultSet rs1 = c.createStatement().executeQuery("select * from activity ORDER BY ActivityID DESC");
                        if (rs1.next()) {
                                String UserNamePass = rs1.getString("username");
                                System.out.println(UserNamePass);
                                ResultSet rs = c.createStatement().executeQuery("select firstName,lastName,profilePicture from employee where " +
                                        "username = '" + UserNamePass + "'");

                                if (rs.next()) {
                                        String firstName = rs.getString("firstName");
                                        String lastName = rs.getString("lastName");
                                        labelName.setText(firstName + " " + lastName);
                                        Blob blob = rs.getBlob(3);
                                        InputStream inputStream = blob.getBinaryStream();
                                        Image image = new Image(inputStream);
                                        profilePicView.setImage(image);
                                }

                        }
                } catch (Exception e) {

                }
        }
        public void showReport(ActionEvent actionEvent){
                Task<Void> task = new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                                HashMap parameters = new HashMap();
                                JasperPrint jp = JasperFillManager.fillReport("report/Income_And_Expenses_Report.jasper",parameters,JDBConnector.getConnection());
                                JasperViewer viewer = new JasperViewer(jp,false);
                                viewer.setVisible(true);
                                return null;
                        }
                };
                ExecutorService service = Executors.newCachedThreadPool();
                service.execute(task);
                service.shutdown();
        }

}


