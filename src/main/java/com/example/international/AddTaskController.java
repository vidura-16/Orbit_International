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

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddTaskController {
    @FXML
    private TextField TaskNo1;

    @FXML
    private Label label1;

    @FXML
    private TextArea Task;

    @FXML
    private Label label2;

    @FXML
    private DatePicker Dot;

    @FXML
    private Label label3;

    @FXML
    private ChoiceBox<String> txtPosition;

    private String[] position = { "Senior Employee", "Employee"};

    @FXML
    private Label label4;

    @FXML
    private TextField EmpID;

    @FXML
    private Label label5;

    @FXML
    private TextField Description;


    @FXML
    private Label label6;

    @FXML
    private Button Add;

    @FXML
    private Button Update;

    @FXML
    private Button Delete;

    @FXML
    private TableView<AddTask> TaskTable;

    @FXML
    private TableColumn<AddTask, String> coldate;

    @FXML
    private TableColumn<AddTask, String> coldescription;

    @FXML
    private TableColumn<AddTask, String> colStatus;

    @FXML
    private TableColumn<AddTask, String> colempid;

    @FXML
    private TableColumn<AddTask, Integer> colid;

    @FXML
    private TableColumn<AddTask, String> colposition;

    @FXML
    private TableColumn<AddTask, String> coltask;

    @FXML
    private TableColumn<AddTask, Integer> coltaskno;
    @FXML
    private Label txtstatus;



    @FXML
    private MenuItem deleteUsers;
    @FXML
    public void initialize() {

        txtPosition.getItems().addAll(position);
        Connect();
        loadData();
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

    ObservableList<Employee> taskList = FXCollections.observableArrayList();

    @FXML
    void SaveButtonAction(ActionEvent event) {

        Connect();

        String taskNo = TaskNo1.getText();
        String task = Task.getText();
        LocalDate dateOfTask = Dot.getValue();
        String position = txtPosition.getValue();
        String empID = EmpID.getText();
        String desc = Description.getText();
        String TaskStatus = "pending";


        Validatetaskno();
        ValidateTask();
        ValidateDate();
        ValidateEmpID();
        ValidatePosition();



        try {
            pst = (PreparedStatement) c.prepareStatement("insert into tasktbl(taskNo, Task, Date, EmpID,Position,Description,TStatus)values (?,?,?,?,?,?,?)");
            pst.setString(1, taskNo);
            pst.setString(2, task);
            pst.setString(3, String.valueOf(dateOfTask));
            pst.setString(4,empID);
            pst.setString(5, position);
            pst.setString(6, desc);
            pst.setString(7,TaskStatus);




            int status = pst.executeUpdate();

            if (status == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Task");
                alert.setContentText("Task Added Successfully");
                alert.showAndWait();
                Refresh();
                lableRefresh();
                TaskNo1.setText("");
                Task.setText("");
                Dot.setPromptText("");
                txtPosition.setValue("");
                EmpID.setText("");
                Description.setText("");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    @FXML
    void handleMouseAction(MouseEvent event){
        AddTask Taskt = TaskTable.getSelectionModel().getSelectedItem();
        TaskNo1.setText(String.valueOf(Taskt.getTaskNo()));
        Task.setText(Taskt.getTask());
        Dot.setPromptText(Taskt.getDate());
        txtPosition.setValue(Taskt.getPosition());
        EmpID.setText(Taskt.getEmpID());
        Description.setText(Taskt.getDescription());

    }
    ObservableList<AddTask> TaskList = FXCollections.observableArrayList();

    public void Refresh(){
        TaskList.clear();
        loadData();
    }
    public void loadData(){
        try {

            String status = "pending";
            ResultSet rs = c.createStatement().executeQuery("select TaskID, taskNo, Task, EmpID, Date, Position, Description,TStatus from tasktbl where TStatus ='"+status+"'");
            while (rs.next()) {
                TaskList.add(new AddTask(rs.getInt("TaskID"), rs.getInt("taskNo"), rs.getString("Task"),
                        rs.getString("EmpID"), rs.getString("Date"), rs.getString("Position"), rs.getString("Description"),rs.getString("TStatus")));
            }
            colid.setCellValueFactory(new PropertyValueFactory<>("TaskID"));
            coltaskno.setCellValueFactory(new PropertyValueFactory<>("taskNo"));
            coltask.setCellValueFactory(new PropertyValueFactory<>("Task"));
            colempid.setCellValueFactory(new PropertyValueFactory<>("EmpID"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("Date"));
            colposition.setCellValueFactory(new PropertyValueFactory<>("Position"));
            coldescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
            colStatus.setCellValueFactory(new PropertyValueFactory<>("taskStatus"));


            TaskTable.setItems(TaskList);
            fieldRefresh();
            lableRefresh();


        } catch (SQLException ex) {
            Logger.getLogger(AddTaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML

    public void Delete(ActionEvent event) {
        Connect();
        String sql = "delete from tasktbl where TaskID = ?";
        try {
            pst =  c.prepareStatement(sql);
            pst.setString(1, TaskNo1.getText());
            System.out.println(TaskNo1.getText());
            int i = pst.executeUpdate();
            if (i == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Task Details");
                alert.setContentText("Task Details Deleted Successfully");
                alert.showAndWait();
                Refresh();
                fieldRefresh();
                TaskNo1.setText("");
                Task.setText("");
                Dot.setPromptText("");
                txtPosition.setValue("");
                EmpID.setText("");
                Description.setText("");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void fieldRefresh(){
        TaskNo1.setText("");
        Task.setText("");
        Dot.setPromptText("");
        txtPosition.setValue("");
        EmpID.setText("");
        Description.setText("");
    }
    private void lableRefresh() {
        label1.setText("");
    }

    public void Update(ActionEvent event) {
        try {
            Connect();

            String value1 = TaskNo1.getText();
            String value2 = Task.getText();
            LocalDate value3 = Dot.getValue();
            String value4 = txtPosition.getValue();
            String value5 = EmpID.getText();
            String value6 = Description.getText();


            String sql = "update tasktbl set taskNo ='" + value1 + "', Task='" + value2 + "', Date='" + value3 + "' , Position ='" + value4 + "'" +
                    ", EmpID='" + value5 + "', Description='" + value6 +"' where taskNo='" + value1 + "'" ;


            pst =  c.prepareStatement(sql);
            int a = pst.executeUpdate();
            if (a == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Task Details");
                alert.setContentText("Task Details Updated Successfully");
                alert.showAndWait();
                Refresh();
                TaskNo1.setText("");
                Task.setText("");
                Dot.setPromptText("");
                txtPosition.setValue("");
                EmpID.setText("");
                Description.setText("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Validatetaskno(){
        if (TaskNo1.getText().isEmpty() || TaskNo1.getText().matches("[a-z A-Z]+")){
            label1.setText("Enter a valid number");
            label1.setStyle("-fx-color:red");

        }else
            label1.setText("");
    }


    private void ValidateEmpID() {
        if (EmpID.getText().isEmpty() || EmpID.getText().matches("[a-z A-Z]+")){
            label5.setText("Enter a valid number");
            label5.setStyle("-fx-color:red");

        }else
            label5.setText("");

    }


    private void ValidatePosition() {

        if(txtPosition.getValue().isEmpty()){
            label4.setText("Please select a Position");
        }else{
            label4.setText("");
        }
    }


    private void ValidateDate() {
        if(Dot.getValue()==null){
            label3.setText("Select a date");
        }else {
            label3.setText("");
        }
    }


    private void ValidateTask() {
        if (Task.getText().isEmpty()) {
            label2.setText("Please enter a Task");
            label2.setStyle("-fx-color:red");
        }else
            label2.setText("");
    }

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



    PreparedStatement pst1;

    public void logout(ActionEvent event) throws IOException {
        String sql = "delete from activity";
        try {
            Connect();
            pst =  c.prepareStatement(sql);
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
    private Button btnJobs;

    @FXML
    void viewJobs(ActionEvent event) throws IOException {
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

}

