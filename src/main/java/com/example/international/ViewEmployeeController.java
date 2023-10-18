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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewEmployeeController implements Initializable {

    public Label labelTot;

    public TextField txtKeyword;

    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, String> colFirstName;

    @FXML
    private TableColumn<Employee, String> colLastName;

    @FXML
    private TableColumn<Employee, String> colStatus;

    @FXML
    private TableColumn<Employee, String> colEmail;

    @FXML
    private TableColumn<Employee, String> colUsername;

    @FXML
    private TableColumn<Employee, String> colPassword;

    @FXML
    private TableColumn<Employee, String> colSalary;

    @FXML
    private TableColumn<Employee, String> colContact;

    @FXML
    private TableColumn<Employee, String> colDateOfJoin;

    @FXML
    private TableColumn<Employee, String> colNic;

    @FXML
    private TableColumn<Employee, String> colAddress;

    @FXML
    private TableColumn<Employee, String> colDob;

    @FXML
    private TableColumn<Employee, String> colGender;

    @FXML
    private TableColumn<Employee, Integer> colEmpID;

    @FXML
    private Button btnUpdate;

    @FXML
    private Label txtCount;

    @FXML
    private Label labelCount;

    @FXML
    private TextField fieldFirstName;

    @FXML
    private TextField fieldLastName;

    @FXML
    private TextField fieldStatus;

    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldContact;

    @FXML
    private PasswordField filedPassword;

    @FXML
    private TextField fieldUsername;

    @FXML
    private TextField filedSalary;

    @FXML
    private DatePicker fieldDateOfJoin;

    @FXML
    private DatePicker fieldDOB;

    @FXML
    private TextField fieldAddress;

    @FXML
    private TextField fieldNIC;

    @FXML
    private ImageView imgView;

    @FXML
    private Label fieldID;

    @FXML
    private Button UpdateButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private ImageView ImageView;

    ObservableList<Employee> oblist = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> txtPosition;

    private String[] position ={"Manager","Senior Employee","Employee"};

    @FXML
    private ChoiceBox<String> fieldGender;

    private String[] gender ={"Male","Female"};

    @FXML
    private Label labelPosition;

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
    private Button btnAddEmployee;

    @FXML
    private Button btnMails;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnAddtask;

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

    @FXML
    private Button btnJobs;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Connect();
        loadData();
        txtPosition.getItems().addAll(position);
        fieldGender.getItems().addAll(gender);
    }

    public void loadData() {
        try {

            ResultSet rs = c.createStatement().executeQuery("select firstName, lastName, status, password," +
                    "email, address, dob, gender, username, nic, dateofJoin, telephoneNum, salary,EmpID from employee");
            while (rs.next()) {
                oblist.add(new Employee(rs.getString("firstName"), rs.getString("lastName"), rs.getString("status"),
                        rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("salary"),
                        rs.getString("telephoneNum"), rs.getString("dateofJoin"), rs.getString("nic"),
                        rs.getString("address"), rs.getString("dob"), rs.getString("gender"),rs.getInt("EmpID")));
            }
            colFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            colLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
            colStatus.setCellValueFactory(new PropertyValueFactory<>("Position"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
            colUsername.setCellValueFactory(new PropertyValueFactory<>("Username"));
            colPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
            colSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
            colContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
            colDateOfJoin.setCellValueFactory(new PropertyValueFactory<>("DateOfJoin"));
            colNic.setCellValueFactory(new PropertyValueFactory<>("NIC"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
            colDob.setCellValueFactory(new PropertyValueFactory<>("DOB"));
            colGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
            colEmpID.setCellValueFactory(new PropertyValueFactory<>("ID"));

            table.setItems(oblist);

            EmployeeCount();

            FilteredList<Employee> filteredData = new FilteredList<>(oblist, b -> true);

            txtKeyword.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(Employee -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }
                    String searchkeyword = newValue.toLowerCase();

                    if (Employee.getFirstName().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;
                    } else if (Employee.getLastName().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;
                    } else if (Employee.getPosition().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;
                    } else if (Employee.getEmail().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;
                    } else if (Employee.getUsername().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;
                    } else if (Employee.getAddress().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;
                    } else {
                        return false;
                    }
                });
            });

            SortedList<Employee> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(table.comparatorProperty());

            table.setItems(sortedData);

        } catch (SQLException ex) {
            Logger.getLogger(ViewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EmployeeCount() {
        try {
            pst = c.prepareStatement("SELECT COUNT(*) AS employeeCount FROM employee");
            ResultSet r = pst.executeQuery();
            while (r.next()) {
                int count = r.getInt("employeeCount");

                txtCount.setText(String.valueOf(count));
                labelCount.setText("Total" + '\n' + "Employees");
            }
        } catch (SQLException ex) {

        }
    }

    @FXML
    void handleMouseAction(MouseEvent event){
        Employee employee = table.getSelectionModel().getSelectedItem();
        fieldFirstName.setText(employee.getFirstName());
        fieldLastName.setText(employee.getLastName());
        fieldEmail.setText(employee.getEmail());
        fieldUsername.setText(employee.getUsername());
        filedPassword.setText(employee.getPassword());
        filedSalary.setText(employee.getSalary());
        txtPosition.setValue(employee.getPosition());
        fieldContact.setText(employee.getContact());
        fieldDateOfJoin.setPromptText(employee.getDateOfJoin());
        fieldNIC.setText(employee.getNIC());
        fieldAddress.setText(employee.getAddress());
        fieldDOB.setPromptText(employee.getDOB());
        fieldGender.setValue(employee.getGender());
        fieldID.setText(String.valueOf(employee.getID()));
            try {
                String id = fieldID.getText();
                ResultSet rs = c.createStatement().executeQuery("select profilePicture from employee where EmpID= '"+id+"'");
                if(rs.next()){
                    Blob blob = rs.getBlob(1);
                    InputStream inputStream = blob.getBinaryStream();
                    Image image = new Image(inputStream);
                    ImageView.setImage(image);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @FXML
    public void Delete(ActionEvent event) {
        String sql = "delete from employee where EmpID = ?";
        try {
            pst = c.prepareStatement(sql);
            pst.setString(1, fieldID.getText());
            int i = pst.executeUpdate();
            if (i == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Employee Details");
                alert.setContentText("Employee Details Deleted Successfully");
                alert.showAndWait();
                EmployeeCount();
                refresh();
                clearFields();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Update(ActionEvent event) {

        try{
            Connect();

            String value1 = fieldFirstName.getText();
            String value2 = fieldLastName.getText();
            String value3 = txtPosition.getValue();
            String value4 = fieldEmail.getText();
            String value5 = filedSalary.getText();
            String value6 = fieldContact.getText();
            LocalDate value7 = fieldDOB.getValue();
            LocalDate value8 = fieldDateOfJoin.getValue();
            String value9 = fieldUsername.getText();
            String value10 = filedPassword.getText();
            String value11 = fieldNIC.getText();
            String value12 = fieldAddress.getText();
            String value13 = fieldGender.getValue();
            String value14 = fieldID.getText();

            validateFirstName();
            validateLastName();
            validateEmail();
            validatePosition();
            validateSalary();
            validateContact();
            validateUsername();
            validatePassword();
            validateAddress();
            validateNIC();

            if(value1.isBlank() == false && value1.isBlank() == false && value3.isBlank() == false && value4.isBlank() == false && value5.isBlank() == false
                    && value6.isBlank() == false && value9.isBlank() == false && value10.isBlank() == false && value11.isBlank() == false && value12.isBlank() == false
                    && value13.isBlank() == false ) {
                String sql = "update employee set firstName='" + value1 + "', lastName='" + value2 + "', status='" + value3 + "' , email='" + value4 + "'" +
                        ", salary='" + value5 + "', telephoneNum='" + value6 + "', dob='" + value7 + "', dateofJoin='" + value8 + "', username='" + value9 + "', " +
                        "password='" + value10 + "', nic='" + value11 + "', address='" + value12 + "', gender='" + value13 + "' where EmpID='" + value14 + "'";

                pst = c.prepareStatement(sql);

                int a = pst.executeUpdate();
                if (a == 1) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("Employee Details");
                    alert.setContentText("Employee Details Updated Successfully");
                    alert.showAndWait();
                    refresh();
                    clearFields();
                }
            }

            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Employee Details");
                alert.setContentText("Employee Details Update Failed");
            }

        } catch(NullPointerException e2){
            e2.printStackTrace();
        } catch(SQLException e3){
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clearFields(){
        fieldFirstName.setText("");
        fieldLastName.setText("");
        txtPosition.setValue(null);
        fieldEmail.setText("");
        filedSalary.setText("");
        fieldContact.setText("");
        fieldDOB.getEditor().clear();
        fieldDateOfJoin.getEditor().clear();
        fieldUsername.setText("");
        filedPassword.setText("");
        fieldNIC.setText("");
        fieldAddress.setText("");
        fieldGender.setValue(null);
        fieldID.setText("");
        ImageView.setImage(null);
        fieldFirstName.setStyle(null);
        fieldLastName.setStyle(null);
        txtPosition.setValue(null);
        fieldEmail.setStyle(null);
        filedSalary.setStyle(null);
        fieldContact.setStyle(null);
        fieldDOB.setStyle(null);
        fieldDateOfJoin.setStyle(null);
        fieldUsername.setStyle(null);
        filedPassword.setStyle(null);
        fieldNIC.setStyle(null);
        fieldAddress.setStyle(null);
        fieldGender.setStyle(null);
        fieldID.setStyle(null);
    }
    public void BrowseButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Picture");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*jpg"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if(selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            ImageView.setImage(image);
        }
    }
    public void refresh() {
        oblist.clear();
        loadData();
    }

    
    public void validateFirstName() {
        if (fieldFirstName.getText().isBlank()) {
            fieldFirstName.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            fieldFirstName.setStyle(null);
        }
    }

    public void validateLastName() {
        if (fieldLastName.getText().isEmpty() || fieldLastName.getText().matches("[0-9]+")) {
            fieldLastName.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            fieldLastName.setStyle(null);
        }
    }

    public void validateEmail() {
        if (fieldEmail.getText().matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")) {
            fieldEmail.setStyle(null);
        } else{
            fieldEmail.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        }
    }

    public void validatePosition() {
        if (txtPosition.getValue().isEmpty() || txtPosition.getValue().matches("[0-9]+")) {
            txtPosition.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else {
            txtPosition.setStyle("");
        }
    }

    public void validateSalary() {
        if(filedSalary.getText().isEmpty() || filedSalary.getText().matches("[a-zA-Z]+")){
            filedSalary.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            filedSalary.setStyle("");
        }
    }

    public void validateContact() {
        if (fieldContact.getText().isEmpty() || fieldContact.getText().matches("[a-zA-Z]+")) {
            fieldContact.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            fieldContact.setStyle(null);
        }
    }

    public void validateUsername() {
        if (fieldUsername.getText().isEmpty()) {
            fieldUsername.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            fieldUsername.setStyle(null);
        }
    }
    public void validatePassword() {
        if (filedPassword.getText().isEmpty()){
            filedPassword.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            filedPassword.setStyle(null);
        }
    }
    public void validateAddress() {
        if (fieldAddress.getText().isEmpty()) {
            fieldAddress.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            fieldAddress.setStyle(null);
        }
    }

    public void validateNIC() {
        if (fieldNIC.getText().matches("[0-9]*([Vv]+)+") || fieldNIC.getText().matches("[0-9]*12")) {
            fieldNIC.setStyle(null);
        } else{
            fieldNIC.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        }
    }

    public void ShowReport(ActionEvent event) {
       try {
            JasperDesign jd = JRXmlLoader.load("report/EmpReport.jrxml");
            HashMap param = new HashMap();
            param.put("FirstName", fieldFirstName.getText());
            param.put("LastName", fieldLastName.getText());
            param.put("Email", fieldEmail.getText());
            param.put("ContactNum", fieldContact.getText());
            param.put("Position", txtPosition.getValue());
            param.put("Salary", filedSalary.getText());
            param.put("NIC", fieldNIC.getText());
            param.put("Address", fieldAddress.getText());
            param.put("Gender", fieldGender.getValue());
            param.put("DateOfBirth", fieldDOB.getPromptText());
            param.put("DateOfJoin", fieldDateOfJoin.getPromptText());
            param.put("EmpID", fieldID.getText());
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Employee Report");
            jv.setVisible(true);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}

