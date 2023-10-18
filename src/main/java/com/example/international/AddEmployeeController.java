package com.example.international;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddEmployeeController {

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtPath;

    @FXML
    private Button btnBrowse;

    @FXML
    private Label viewEmployee;

    @FXML
    private Label txtCount;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField txtSalary;

    @FXML
    private DatePicker txtDob;

    @FXML
    private DatePicker txtDateOfJoin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label31;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    @FXML
    private Label label8;

    @FXML
    private Label label9;

    @FXML
    private Label label10;

    @FXML
    private Label label20;

    @FXML
    private Label label21;

    @FXML
    private Label label22;

    @FXML
    private Label label23;

    @FXML
    private Button btnReset;

    @FXML
    private ChoiceBox<String> txtPosition;

    private String[] position = {"Manager", "Senior Employee", "Employee"};

    @FXML
    private ChoiceBox<String> txtGender;

    private String[] gender = {"Male", "Female"};

    @FXML
    private Label labelPosition;

    @FXML
    private Label tTime;

    @FXML
    private Label text;

    @FXML
    private Label labelEmpID;

    @FXML
    private Label label711;

    @FXML
    private Label label82;

    @FXML
    private Button btnSave;

    @FXML
    private Label label811;


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
    void viewMails(ActionEvent event) throws IOException{
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

    public AddEmployeeController() throws FileNotFoundException {

    }

    @FXML
    public void initialize() {
        txtPosition.getItems().addAll(position);
        txtGender.getItems().addAll(gender);
    }

    private FileInputStream fis;

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

    public void BrowseButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Picture");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*jpg"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            txtPath.setText(selectedFile.getAbsolutePath());
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
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


    public void DateValidation1() {
        if (txtDateOfJoin.getValue() == null) {
            label811.setText("Please select a date");
        }
        else {
            label811.setText("");
        }
    }

    public void DateValidation2() {
        if (txtDob.getValue() == null) {
            label82.setText("Please select a date");
        }
        else {
            label82.setText("");
        }
    }
    @FXML
    void SaveButtonAction(ActionEvent event) throws FileNotFoundException {

        Connect();

        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String email = txtEmail.getText();
        String gender = txtGender.getValue();
        String nic = txtNic.getText();
        String telephoneNum = txtContact.getText();
        String address = txtAddress.getText();
        String profilePicture = txtPath.getText();
        String username = txtUsername.getText();
        String position = txtPosition.getValue();
        String salary = txtSalary.getText();
        LocalDate date = txtDob.getValue();
        LocalDate dateJoin = txtDateOfJoin.getValue();
        String password = txtPassword.getText();

        FirstNameValidate();
        LastNameValidate();
        EmailValidate();
        GenderValidation();
        ImageValidation();
        NICValidate();
        ContactValidate();
        AddressValidate();
        UsernameValidate();
        PasswordValidate();
        SalaryValidate();
        PositionValidation();
        DateValidation1();
        DateValidation2();

        try {


            pst = c.prepareStatement("insert into employee(firstName, lastName, username, password, profilePicture, " +
                    "email, address, dob, gender, status, nic, dateofJoin, telephoneNum, salary)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, username);
            pst.setString(4, password);
            InputStream inputStream = new FileInputStream(new File(profilePicture));
            pst.setBlob(5, inputStream);
            pst.setString(6, email);
            pst.setString(7, address);
            pst.setString(8, String.valueOf(date));
            pst.setString(9, gender);
            pst.setString(10, position);
            pst.setString(11, nic);
            pst.setString(12, String.valueOf(dateJoin));
            pst.setString(13, telephoneNum);
            pst.setString(14, salary);

            int status = pst.executeUpdate();

            if (status == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Employee");
                alert.setContentText("Employee Details Added Successfully");
                alert.showAndWait();

                ResetButtonAction();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    private void ResetButtonAction() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtUsername.setText("");
        txtPath.setText("");
        txtPassword.setText("");
        txtNic.setText("");
        txtContact.setText("");
        imageView.setImage(null);
        txtSalary.setText("");
        txtDob.getEditor().clear();
        txtDateOfJoin.getEditor().clear();
        txtPosition.setValue(null);
        txtGender.setValue(null);
        label1.setText("");
        label2.setText("");
        label3.setText("");
        label4.setText("");
        label5.setText("");
        label6.setText("");
        label7.setText("");
        label8.setText("");
        label9.setText("");
        label10.setText("");
        label20.setText("");
        label21.setText("");
        label22.setText("");
        label23.setText("");
    }

    public void FirstNameValidate() {
        if (txtFirstName.getText().isEmpty() || txtFirstName.getText().matches("[0-9]+")) {
            label1.setText("Please enter a correct First Name");
        } else {
            label1.setText("");
        }
    }
    public void LastNameValidate() {
        if (txtLastName.getText().isEmpty() || txtFirstName.getText().matches("[0-9]+")) {
            label2.setText("Please enter a correct Last Name");
        } else {
            label2.setText("");
        }
    }

    public void ContactValidate() {
        if (txtContact.getText().isEmpty()) {
            label5.setText("Please enter a correct Contact Number");
        }
        else{
            label5.setText("");
        }
    }

    public void AddressValidate() {
        if (txtAddress.getText().isEmpty()) {
            label6.setText("Please enter a correct Address");
        }
        else{
            label6.setText("");
        }
    }

    public void UsernameValidate() {
        if (txtUsername.getText().isEmpty()) {
            label22.setText("Please enter a correct User Name");
        }
        else{
            label22.setText("");
        }
    }

    public void PasswordValidate() {
        if (txtPassword.getText().isEmpty()) {
            label23.setText("Please enter a correct Password");
        }
        else{
            label23.setText("");
        }
    }

    public void SalaryValidate() {
        if (txtSalary.getText().isEmpty()) {
            label21.setText("Please enter a correct Salary value");
        }
        else{
            label21.setText("");
        }
    }

    public void EmailValidate() {
        if (txtEmail.getText().matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")) {
            label3.setText("");
        } else {
            label3.setText("Please enter a correct Email Address");
        }
    }

    public void NICValidate() {
        if (txtNic.getText().matches("[0-9]*([Vv]+)+") || txtNic.getText().matches("[0-9]*12")) {
            label4.setText("");
        } else {
            label4.setText("Please enter a correct NIC Number");
        }
    }

    public void ImageValidation() {
        if (txtPath.getText().isEmpty()) {
            label8.setText("Please select a Profile Picture");
        }
        else {
            label8.setText("");
        }
    }

    public void GenderValidation() {
        boolean GenderSelection = txtGender.getSelectionModel().isEmpty();
        if(GenderSelection == true){
            label7.setText("Please select a Gender");
        }else{
            label7.setText("");
        }
    }

    public void PositionValidation() {
        boolean PositionSelection = txtPosition.getSelectionModel().isEmpty();
        if(PositionSelection == true){
            label20.setText("Please select a Position");
        }
        else{
            label20.setText("");
        }
    }


}
