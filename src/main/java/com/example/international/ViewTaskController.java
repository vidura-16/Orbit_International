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
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewTaskController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<AddTask> ViewTaskTable;

    @FXML
    private Button btndone;

    @FXML
    private Button btnpending;

    @FXML
    private Button btnViewEmployee;

    @FXML
    private TableColumn<AddTask,String> colStatus;

    @FXML
    private TableColumn<AddTask, String> coldate;

    @FXML
    private TableColumn<AddTask, String> coldescription;

    @FXML
    private TableColumn<AddTask, Integer> colid;

    @FXML
    private TableColumn<AddTask, String> coltask;

    @FXML
    private TableColumn<AddTask, Integer> coltaskno;

    @FXML
    private MenuItem deleteUsers;

    @FXML
    private TextField txtTask;

    @FXML
    private TextField txtTaskID;

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
    void OnActionLeaveRequests(ActionEvent event) throws IOException{
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
    void OnActionMails(ActionEvent event) throws IOException{
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
    void OnActionViewApplicant(ActionEvent event) throws IOException{
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
    void ViewAlert(ActionEvent event) throws IOException{
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
    void ViewVacancies(ActionEvent event) throws IOException{
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
    void dashboard(ActionEvent event) throws IOException{
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
    void viewTodoList(ActionEvent event) throws IOException{
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

    public void initialize() {

        Connect();
        loadData();
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




    ObservableList<AddTask> TaskList = FXCollections.observableArrayList();

    public void Refresh(){
        TaskList.clear();
        loadData();
    }
    public void loadData(){
        try {

            ResultSet rs = c.createStatement().executeQuery("select TaskID, taskNo, Task, EmpID, Date, Position, Description ,TStatus from tasktbl");
            while (rs.next()) {
                TaskList.add(new AddTask(rs.getInt("TaskID"), rs.getInt("taskNo"), rs.getString("Task"),
                        rs.getString("EmpID"), rs.getString("Date"), rs.getString("Position"), rs.getString("Description"),rs.getString("TStatus")));
            }
            colid.setCellValueFactory(new PropertyValueFactory<>("taskID"));
            coltaskno.setCellValueFactory(new PropertyValueFactory<>("taskNo"));
            coltask.setCellValueFactory(new PropertyValueFactory<>("task"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
            coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            colStatus.setCellValueFactory(new PropertyValueFactory<>("taskStatus"));
            ViewTaskTable.setItems(TaskList);



        } catch (SQLException ex) {
            Logger.getLogger(ViewTaskController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    void handleMouseAction(MouseEvent event){
        AddTask Viewt = ViewTaskTable.getSelectionModel().getSelectedItem();
        txtTaskID.setText(String.valueOf(Viewt.getTaskNo()));
        txtTask.setText(Viewt.getTask());



}
    @FXML
    void SaveButtonAction(ActionEvent event) {

try{
    Connect();
    String value1 = txtTaskID.getText();
    String value2= "Done";


    String sql = "update tasktbl set TStatus ='" + value2 + "' where taskNo='" + value1 + "'" ;

    pst = (PreparedStatement) c.prepareStatement(sql);
    int a = pst.executeUpdate();
    if (a == 1) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Task Details");
        alert.setContentText("Task Details Updated Successfully");
        alert.showAndWait();
        Refresh();

    }

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
    private Label AlertCountLabel;

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