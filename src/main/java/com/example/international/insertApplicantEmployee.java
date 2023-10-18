package com.example.international;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class insertApplicantEmployee implements Initializable {

    @FXML
    private Label welcomeText;
    @FXML
    private TextField txtImgUrl;


    @FXML
    private Button btnImg;
    private FileInputStream fis;
    private FileChooser filechooser;
    private Button browse;
    private File file;

    @FXML
    private TextField searchEmployee;

    @FXML
    private TextField searchApplicant;

    @FXML
    private TextField txtFname;

    @FXML
    public Label fnameWarn;

    @FXML
    private Label lnameWarn;

    @FXML
    private Label emailWarn;

    @FXML
    private Label religonWarn;

    @FXML
    private Label genderWarn;

    @FXML
    private Label ageWarn;

    @FXML
    private Label imgWarn;

    @FXML
    private Label nicWarn;

    @FXML
    private Label addressWarn;

    @FXML
    private Label passnoWarn;

    @FXML
    private Label nationalityWarn;

    @FXML
    private Label doeWarn;

    @FXML
    private Label pobWarn;

    @FXML
    private Label doiWarn;

    @FXML
    private TextField txtLname;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtNumber;

    @FXML
    private TextArea txtAddr;

    @FXML
    private TextField passno;

    @FXML
    private TextField passDateOfIssue;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnAdditional;

    @FXML
    private Button btnReset;

    @FXML
    ToggleGroup religon;

    @FXML
    private DatePicker dateofIssue;

    @FXML
    private ComboBox<String> religonChooser;

    @FXML
    private ComboBox<String> genderChooser;

    @FXML
    private TextField medicalReport;

    @FXML
    private ComboBox<String> Fields;

    @FXML
    private ComboBox<String> Experiences;

    @FXML
    private ChoiceBox<Integer> ageChooser;

    @FXML
    private Label dateLabel;

    @FXML
    private Button btnDash;

    @FXML
    private Button btnAddApplicant;

    @FXML
    private Button btnViewApplicant;

    @FXML
    private Button btnAlerts;

    @FXML
    private Button btnleaveRequest;

    @FXML
    private Button btnToDo;

    @FXML
    private Button btnLogout;

    @FXML
    private ComboBox<String> passNationality;

    @FXML
    private TextField placeOfBirth;

    @FXML
    private DatePicker dateOfExp;

    @FXML
    private Button submit;

    @FXML
    void LeaveRequest(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ApplyLeaveEmployee.fxml"));
        Stage window = (Stage) btnleaveRequest.getScene().getWindow();
        window.setScene(new Scene(root, 1400, 767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void ToDo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("viewTaskEmployee.fxml"));
        Stage window = (Stage) btnToDo.getScene().getWindow();
        window.setScene(new Scene(root, 1400, 767));
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
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeDash.fxml"));
        Stage window = (Stage) btnDash.getScene().getWindow();
        window.setScene(new Scene(root, 1400, 767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void onActionAddApplicant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ApplicantEmployee.fxml"));
        Stage window = (Stage) btnAddApplicant.getScene().getWindow();
        window.setScene(new Scene(root, 1400, 767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void showAlerts(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Alert-Employee.fxml"));
        Stage window = (Stage) btnAlerts.getScene().getWindow();
        window.setScene(new Scene(root, 1400, 767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    void viewApplicant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("viewAllApplicantsEmployee.fxml"));
        Stage window = (Stage) btnViewApplicant.getScene().getWindow();
        window.setScene(new Scene(root, 1400, 767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }

    @FXML
    public void handleOpenProfilePic() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Picture");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*jpg"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            txtImgUrl.setText(selectedFile.getAbsolutePath());
            Image image = new Image(selectedFile.toURI().toString());

        } else {
            txtImgUrl.setText("Please select a profile picture...");
        }
    }

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

    @FXML
    public void loadFile() {
        FileChooser fileChooser1 = new FileChooser();
        fileChooser1.setTitle("Select the Medical Report");
        fileChooser1.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*jpg"));
        File selectedFile = fileChooser1.showOpenDialog(null);

        if (selectedFile != null) {
            medicalReport.setText(selectedFile.getAbsolutePath());
            Image image = new Image(selectedFile.toURI().toString());
            //to get date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            String DateNTime = dtf.format(now);
            String date = DateNTime.substring(0, 10);
            dateLabel.setText(date);

        } else {
            txtImgUrl.setText("Please select a the Medical Report");
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
            primaryStage.setScene(new Scene(root, 900, 600));
            primaryStage.show();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button btnMails;

    @FXML
    private Button btnAddtask;

    @FXML
    private Button btnViewEmployee;


    @FXML
    void SaveButtonAction(ActionEvent event) throws FileNotFoundException {


        Connect();

        validateimage();
        validateNIC();
        validatePlace();
        validateContact();
        validateFirstName();
        validateAddress();
        validatePassword();
        validatePassno();
        validateAge();
        validateLastName();
        validateEmail();
        validateGender();
        validateNationality();
        validateFields();
        validateJob();

        String firstName = txtFname.getText();
        String lastName = txtLname.getText();
        String email = txtEmail.getText();
        String Religon = religonChooser.getSelectionModel().getSelectedItem().toString();
        String Gender = genderChooser.getSelectionModel().getSelectedItem().toString();
        String telephoneNum = txtNumber.getText();
        String address = txtAddr.getText();
        ///InputStream profilePicture = new FileInputStream(txtImgUrl.getText());
        String nic = txtNic.getText();
        int age = Integer.parseInt(txtAge.getText());
        String passportnum = passno.getText();
        LocalDate issueDate = dateofIssue.getValue();
        //String formatissue=issueDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate expDate = dateOfExp.getValue();
        //String formatExp=expDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String nationality = passNationality.getSelectionModel().getSelectedItem().toString();
        String placeofBirth = placeOfBirth.getText();
        String Status = "not yet";
        String Experience = Experiences.getSelectionModel().getSelectedItem().toString();
        String Field = Fields.getSelectionModel().getSelectedItem().toString();


        try {

            pst = c.prepareStatement("insert into applicant(Fname,Lname,age,email,mobile,religon,gender,address,nic,passportum,passIssueDate," +
                    "passExpDate,nationality,placeOfBirth,img,field,experience,medical,status) " +
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setInt(3, age);
            pst.setString(4, email);
            pst.setString(5, telephoneNum);
            pst.setString(6, Religon);
            pst.setString(7, Gender);
            pst.setString(8, address);
            pst.setString(9, nic);
            pst.setString(10, passportnum);
            pst.setString(11, String.valueOf(issueDate));
            pst.setString(12, String.valueOf(expDate));
            pst.setString(13, nationality);
            pst.setString(14, placeofBirth);
            InputStream inputStream = new FileInputStream(new File(txtImgUrl.getText()));
            pst.setBinaryStream(15, inputStream, inputStream.available());
            pst.setString(16, Field);
            pst.setString(17, Experience);
            InputStream inputStream2 = new FileInputStream(new File(medicalReport.getText()));
            pst.setBinaryStream(18, inputStream2, inputStream2.available());
            pst.setString(19, Status);

            int status = pst.executeUpdate();

            if (status == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Applicant");
                alert.setContentText("Applicant Details Added Successfully");
                alert.showAndWait();

                txtFname.setText("");
                txtLname.setText("");
                txtEmail.setText("");
                txtAge.setText("");
                txtNic.setText("");
                txtNumber.setText("");
                txtAddr.setText("");
                passno.setText("");
                placeOfBirth.setText("");
                religonChooser.setValue("");
                genderChooser.setValue("");
                dateofIssue.setPromptText("");
                dateOfExp.setPromptText("");
                txtImgUrl.setText("");
                medicalReport.setText("");
                Fields.setValue("");
                Experiences.setValue("");
                passNationality.setValue("");


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Success");
                alert.setHeaderText("Employee");
                alert.setContentText("Employee Details Adding Failed");
                alert.showAndWait();
            }


        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton female;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> religons = FXCollections.observableArrayList("Buddhism", "Christianity", "Hinduism", "Islam");
        religonChooser.setItems(religons);
        ObservableList<String> gender = FXCollections.observableArrayList("Male", "Female", "Other");
        genderChooser.setItems(gender);
        ObservableList<String> nationalities = FXCollections.observableArrayList("Sri Lankan", "Other");
        passNationality.setItems(nationalities);
        ObservableList<String> fields = FXCollections.observableArrayList("Cheff", "Cooking", "Cleaners", "Co-Worker", "Driving", "House maids", "Janitor", "Security", "Shop keeper");
        Fields.setItems(fields);
        ObservableList<String> experiences = FXCollections.observableArrayList("Less than 1 year", "1 year Experience", "2 year Experience", "3 year experience", "4 year experience", "5 year experience", "More than 5 years");
        Experiences.setItems(experiences);

        AlertCount();
    }




    public void validateFirstName() {
        if (txtFname.getText().isBlank()) {
            txtFname.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            txtFname.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }

    public void validateLastName() {
        if (txtLname.getText().isEmpty() || txtLname.getText().matches("[0-9]+")) {
            txtLname.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            txtLname.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }

    public void validateEmail() {
        if (txtEmail.getText().isEmpty() ) {
            txtEmail.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            txtEmail.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }

    public void validatePlace() {
        if (placeOfBirth.getText().isEmpty() ) {
            placeOfBirth.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else {
            placeOfBirth.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }
    public void validateGender() {
        if (genderChooser.getSelectionModel().getSelectedItem().isEmpty() ) {
            genderChooser.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else {
            genderChooser.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }
    public void validateNationality() {
        if (passNationality.getSelectionModel().getSelectedItem().isEmpty() ) {
            passNationality.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else {
            passNationality.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }


    public void validateFields() {
        if (Fields.getSelectionModel().getSelectedItem().isEmpty() ) {
            Fields.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else {
            Fields.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }

    public void validatePassno() {
        if (passno.getText().isBlank()) {
            passno.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            passno.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }

    public void validateContact() {
        if (txtNumber.getText().isEmpty()) {
            txtNumber.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            txtNumber.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }

    public void validateAge() {
        if (txtAge.getText().isEmpty() ) {
            txtAge.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            txtAge.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }

    public void validateimage() {
        if (txtImgUrl.getText().isEmpty()) {
            txtImgUrl.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            txtImgUrl.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }


    public void validatePassword() {
        if (medicalReport.getText().isEmpty()){
            medicalReport.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            medicalReport.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }
    public void validateAddress() {
        if (txtAddr.getText().isEmpty()) {
            txtAddr.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            txtAddr.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }


    public void validateNIC() {
        if (txtNic.getText().isEmpty()) {
            txtNic.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else{
            txtNic.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        }
    }

    public void validateJob() {
        if (Experiences.getSelectionModel().getSelectedItem().isEmpty() ) {
            Experiences.setStyle("-fx-border-color: red; -fx-border-width: 2px");
        } else {
            Experiences.setStyle("-fx-border-color: black; -fx-border-width: 2px");
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
