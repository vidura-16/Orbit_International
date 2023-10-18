package com.example.international;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LeaveRequestController {
        @FXML
        private TableView<Leave> Leavetbl;

        @FXML
        private TableColumn<Leave, String> colReason;

        @FXML
        private TableColumn<Leave, String> colEmpID;

        @FXML
        private TableColumn<Leave, Integer> colID;

        @FXML
        private TableColumn<Leave, String> colLeaveStatus;

        @FXML
        private TableColumn<Leave, String> colLeaveType;

        @FXML
        private TableColumn<Leave, String> colStartDate;

        @FXML
        private TableColumn<Leave, String> colEndDate;

        @FXML
        private Button btnApprove;

        @FXML
        private Button btnReject;

        @FXML
        private Button btnSubmit;

        @FXML
        private TextField txtEmpID;

        @FXML
        private TextField txtEndDate;

        @FXML
        private TextField txtLeaveType;

        @FXML
        private TextField txtStartDate;

        @FXML
        private TextField txtReason;

        @FXML
        private Button btnAddEmployee;

        @FXML
        private Button btnDash;

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
        private Button btnGenerate;

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
                Parent root=FXMLLoader.load(getClass().getResource("ApplicantManager.fxml"));
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

        ObservableList<Leave> leaverequests = FXCollections.observableArrayList();
        @FXML
        private URL location;
        Connection c;
        PreparedStatement pst;

        public Connection Connect() {
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orbit", "root", "");

                        System.out.println("Connection succeed");
                } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                        System.out.println("Connection failed");
                }return null;
        }
@FXML
ObservableList<Leave> leaves = FXCollections.observableArrayList();
        public void initialize() {
                Connect();
                loadData();

        }

        @FXML
        private Label leaveIDlabel;

        private void loadData() {
                try {

                        ResultSet rs = c.createStatement().executeQuery("select LeaveID , LeaveType, StartDate, Reason,EndDate, EmpID,LeaveStatus from leavetbl");
                        while (rs.next()) {
                                leaves.add(new Leave(rs.getInt("LeaveID"), rs.getString("LeaveType"),
                                        rs.getString("StartDate"), rs.getString("EndDate"),rs.getString("Reason"),
                                        rs.getString("EmpID"), rs.getString("LeaveStatus")));
                        }
                        colID.setCellValueFactory(new PropertyValueFactory<>("leaveID"));
                        colLeaveType.setCellValueFactory(new PropertyValueFactory<>("leaveType"));
                        colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
                        colEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
                        colReason.setCellValueFactory(new PropertyValueFactory<>("reason"));
                        colEmpID.setCellValueFactory(new PropertyValueFactory<>("empID"));
                        colLeaveStatus.setCellValueFactory(new PropertyValueFactory<>("leaveStatus"));



                        Leavetbl.setItems(leaves );



                } catch (SQLException ex) {
                        Logger.getLogger(LeaveRequestController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        public void Refresh(){
                leaves.clear();
                loadData();
        }
        @FXML
        void handleMouseAction(MouseEvent event){
                Leave leavet = Leavetbl.getSelectionModel().getSelectedItem();

                txtEmpID.setText(String.valueOf(leavet.getEmpID()));
                txtLeaveType.setText(leavet.getLeaveType());
                txtStartDate.setText(leavet.getStartDate());
                txtEndDate.setText(leavet.getEndDate());
                txtReason.setText(leavet.getReason());
                leaveIDlabel.setText(String.valueOf(leavet.getLeaveID()));

        }

        @FXML
        void SaveButtonAction(ActionEvent event) {
                try{
                        Connect();
                        String value1 = leaveIDlabel.getText();
                        String value2= "Approved";


                        String sql = "update leavetbl set LeaveStatus ='" + value2 + "' where LeaveID='" + value1 + "'" ;

                        pst = (PreparedStatement) c.prepareStatement(sql);
                        int a = pst.executeUpdate();
                        if (a == 1) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Success");
                                alert.setHeaderText("Leave Details");
                                alert.setContentText("Leave Details Updated Successfully");
                                alert.showAndWait();
                                txtEmpID.setText("");
                        } Refresh();

                } catch (Exception e) {
                        e.printStackTrace();
                }

        }
        @FXML
        void RejectButtonAction(ActionEvent event){
                try {
                        Connect();
                        String value1 = txtEmpID.getText();
                        String value2= "Rejected";


                        String sql = "update leavetbl set LeaveStatus ='" + value2 + "' where EmpID='" + value1 + "'" ;

                        pst = (PreparedStatement) c.prepareStatement(sql);
                        int a = pst.executeUpdate();
                        if (a == 1) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Success");
                                alert.setHeaderText("Leave Details");
                                alert.setContentText("Leave Details Updated Successfully");
                                alert.showAndWait();
                                txtEmpID.setText("");
                        }   Refresh();

                } catch (Exception e) {
                        e.printStackTrace();
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
        @FXML
        void OnActionGenerateReport(ActionEvent event) {
               Task<Void> task = new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                                HashMap parameters = new HashMap();
                                JasperPrint jp = JasperFillManager.fillReport("report/LeaveRequestReport.jasper",parameters, JDBConnector.getConnection());
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










