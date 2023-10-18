package com.example.international;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplyLeaveController {

    @FXML
    private Label AlertCountLabel;

    @FXML
    private DatePicker EndDate;

    @FXML
    private ChoiceBox<String> txtLeaveType;

    private String[] Leavetype = {"Casual Leave", "Anual Leave"};

    @FXML
    private TableView<Leave> TblLeave;

    @FXML
    private TableColumn<Leave, Integer> colID;

    @FXML
    private TableColumn<Leave, String> colLeaveStatus;

    @FXML
    private TextField Reason;

    @FXML
    private TextField txtEmpID;

    @FXML
    private DatePicker StartDate;

    @FXML
    private Button Submit;

    @FXML
    private Button btnDash;

    @FXML
    private Button btnAddApplicant;

    @FXML
    private Button btnViewApplicant;

    @FXML
    private Button btnLeaveRequests;

    @FXML
    private Button btnAlerts;

    @FXML
    private Button btnMail;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnTodo;

    @FXML
    private Button btnViewVacancies;

    @FXML
    void OnActionAddApplicant(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("ApplicantSenior.fxml"));
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
    void OnActionLeaveRequests(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("ApplyLeave.fxml"));
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
    void OnActionViewApplicant(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("viewAllApplicantsSenior.fxml"));
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
    void ViewAlert(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("Alert-SeniorEmployee.fxml"));
        Stage window= (Stage) btnAlerts.getScene().getWindow();
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
    void ViewMail(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("emailSenior.fxml"));
        Stage window= (Stage) btnMail.getScene().getWindow();
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
    void ViewVacancies(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("suggest.fxml"));
        Stage window= (Stage) btnViewVacancies.getScene().getWindow();
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
    void dashboard(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("seniorEmployeeDash.fxml"));
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
    void viewTodoList(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("viewTask.fxml"));
        Stage window= (Stage) btnTodo.getScene().getWindow();
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
    public void initialize() {
        txtLeaveType.getItems().addAll(Leavetype);
        Connect();
        Refresh();
        AlertCount();
    }


    Connection c;
    PreparedStatement pst;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orbit", "root", "");
            System.out.println("Connection succeed");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }
    }


    @FXML
    void SaveButtonAction(ActionEvent event) {
        Connect();

        String leavetype = txtLeaveType.getValue();
        LocalDate startDate = StartDate.getValue();
        LocalDate endDate = EndDate.getValue();
        String reason = Reason.getText();
        String empid = txtEmpID.getText();
        String leaveStatus = "Pending";

        try {
            pst = (PreparedStatement) c.prepareStatement("insert into leavetbl(LeaveType, StartDate, EndDate, Reason,EmpID,LeaveStatus)values (?,?,?,?,?,?)");
            pst.setString(1, leavetype);
            pst.setString(2, String.valueOf(startDate));
            pst.setString(3, String.valueOf(endDate));
            pst.setString(4, reason);
            pst.setString(5, empid);
            pst.setString(6, leaveStatus);


            int status = pst.executeUpdate();

            if (status == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Leave");
                alert.setContentText("Leave Request sent Successfully");
                alert.showAndWait();
                Refresh();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    ObservableList<Leave> leaves = FXCollections.observableArrayList();

    public void Refresh() {
        txtLeaveType.setValue("");
        StartDate.setPromptText("");
        EndDate.setPromptText("");
        Reason.setText("");
        leaves.clear();
        loadData();

    }
    private void loadData() {
        try {

            ResultSet rs = c.createStatement().executeQuery("select LeaveID , LeaveType, StartDate, Reason,EndDate, EmpID,LeaveStatus from leavetbl");
            while (rs.next()) {
                leaves.add(new Leave(rs.getInt("LeaveID"), rs.getString("LeaveType"),
                        rs.getString("StartDate"), rs.getString("EndDate"),rs.getString("Reason"),
                        rs.getString("EmpID"), rs.getString("LeaveStatus")));
            }
            colID.setCellValueFactory(new PropertyValueFactory<>("leaveID"));
            colLeaveStatus.setCellValueFactory(new PropertyValueFactory<>("leaveStatus"));



            TblLeave.setItems(leaves );



        } catch (SQLException ex) {
            Logger.getLogger(LeaveRequestController.class.getName()).log(Level.SEVERE, null, ex);
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

    public void AlertCount() {
        Connect();
        try {
            pst = c.prepareStatement("select announcement,date,visibility,topic from announcement where `visibility` IN('Only for Senior Employee','For All')");
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
