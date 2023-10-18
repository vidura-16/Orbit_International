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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class suggestController implements  Initializable {
    @FXML
    private Label requirementName;

    @FXML
    private Label requirementAge;

    @FXML
    private Label requirementGender;

    @FXML
    private Label requirementReligon;

    @FXML
    private Label requirementQuantity;
    @FXML
    private ChoiceBox<Integer> ageChooser;

    @FXML
    private ChoiceBox<String> genderChooser;

    @FXML
    private ChoiceBox<String> religonChooser;

    @FXML
    private ChoiceBox<String> nationalityChooser;

    @FXML
    private ChoiceBox<String> fieldChooser;


    @FXML
    private TableView<Applicant> table;

    @FXML
    private TableColumn<Applicant, String> colFirstName;

    @FXML
    private TableColumn<Applicant, String> colLastName;

    @FXML
    private TableColumn<Applicant, String> colGender;

    @FXML
    private TableColumn<Applicant, String> colEmail;

    @FXML
    private TableColumn<Applicant, Integer> colAge;

    @FXML
    private TableColumn<Applicant, String> colPassportNum;

    @FXML
    private TableColumn<Applicant, String> colPlace;

    @FXML
    private TableColumn<Applicant, String> colContact;

    @FXML
    private TableColumn<Applicant, String> colDateOfIssue;

    @FXML
    private TableColumn<Applicant, String> colDateofExp;

    @FXML
    private TableColumn<Applicant, String> colNic;

    @FXML
    private TableColumn<Applicant, String> colAddress;

    @FXML
    private TableColumn<Applicant, String> colReligon;

    @FXML
    private TableColumn<Applicant, String> colField;

    @FXML
    private TableColumn<Applicant, String> colNationality;

    @FXML
    private TableColumn<Applicant, Integer> colApplicantID;

    @FXML
    private TableColumn<Applicant, String> colExperience;

    @FXML
    private TableView<requirementData> tabRequirement;

    @FXML
    private TableColumn<requirementData, Integer> colTaskID;

    @FXML
    private TableColumn<requirementData, String> colTask;

    @FXML
    private TableColumn<requirementData, String> colCountry;

    @FXML
    private TableColumn<requirementData, String> colJobGender;

    @FXML
    private TableColumn<requirementData, Integer> colJobAge;

    @FXML
    private TableColumn<requirementData, String> colPeriod;

    @FXML
    private TableColumn<requirementData, String> colJobExp;

    @FXML
    private TableColumn<requirementData, String> colSalary;

    @FXML
    private TableColumn<requirementData, String> colNoVisa;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnAddEmployee;

    @FXML
    private Label txtCount;

    @FXML
    private Label labelCount;

    @FXML
    private TextField filedReligon;

    @FXML
    private TextField fieldContact;

    @FXML
    private DatePicker fieldDateofIssue;

    @FXML
    private TextField fieldLastName;

    @FXML
    private TextField fieldFirstName;

    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldAge;

    @FXML
    private DatePicker fieldDateofEx;

    @FXML
    private TextField fieldPlace;

    @FXML
    private TextField fieldGender;

    @FXML
    private TextField fieldAddress;

    @FXML
    private TextField fieldPassnum;

    @FXML
    private TextField filedNA;

    @FXML
    private TextField fieldNIC;

    @FXML
    private TextField fieldField;

    @FXML
    private TextField fielldExperience;

    @FXML
    private Label applicantID;

    @FXML
    private ImageView imgView;

    @FXML
    private Label fieldJobID;

    @FXML
    private Label fieldCountry;

    @FXML
    private Label fieldJob;

    @FXML
    private Label fieldNoVisa;

    @FXML
    private Label fieldJobAge;

    @FXML
    private Label fieldJobExp;

    @FXML
    private Label fieldPeriod;

    @FXML
    private Label fieldSalary;

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


    @FXML
    void handleMouseAction(MouseEvent event) throws IOException {

        Applicant applicant = table.getSelectionModel().getSelectedItem();
        fieldFirstName.setText(applicant.getFirstName());
        fieldLastName.setText(applicant.getLastName());
        fieldAge.setText(String.valueOf(applicant.getAge()));
        fieldEmail.setText(applicant.getEmail());
        fieldContact.setText(applicant.getMobile());
        filedReligon.setText(applicant.getReligon());
        fieldField.setText(applicant.getField());

      applicantID.setText(String.valueOf(applicant.getApplicantId()));
        fieldGender.setText(applicant.getGender());
        try{
            String id=applicantID.getText();
            ResultSet rs = c.createStatement().executeQuery("select img from applicant  where applicantID ='"+id+"'");
            if(rs.next()){
                Blob blob=rs.getBlob(1);
                InputStream inputStream=blob.getBinaryStream();
                Image image=new Image(inputStream);
                imgView.setImage(image);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }

    @FXML
    private ChoiceBox<String> experienceChooser;
    Connection c;
    PreparedStatement pst;
    ObservableList<requirementData> requirements = FXCollections.observableArrayList();
    public void loadRequirements(){
        try{
            String val="not yet";
            ResultSet rs2= c.createStatement().executeQuery("select jobno,NoOfVisa,title,country,gender,age,period,experience,salary from jobs");
            while(rs2.next()){
                requirements.add(new requirementData(rs2.getInt("jobno"),rs2.getInt("NoOfVisa"), rs2.getString("title"), rs2.getString("country"),rs2.getString("gender"), rs2.getString("age"), rs2.getString("period"), rs2.getString("experience"), rs2.getDouble("salary")));

            }
            colTaskID.setCellValueFactory(new PropertyValueFactory<>("jobID"));
            colTask.setCellValueFactory(new PropertyValueFactory<>("job"));
            colJobAge.setCellValueFactory(new PropertyValueFactory<>("age"));
            colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
            colJobGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            colJobExp.setCellValueFactory(new PropertyValueFactory<>("experience"));
            colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
            colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
            colPeriod.setCellValueFactory(new PropertyValueFactory<>("period"));
            colNoVisa.setCellValueFactory(new PropertyValueFactory<>("noVisa"));
            tabRequirement.setItems(requirements);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void refreshApplicants() {
        ApplicantList.clear();
        seeSuggestions();
    }
    public void refreshRequirements() {
        requirements.clear();
        loadRequirements();
    }


    @FXML
    void handleMouseAction1(MouseEvent event) throws IOException {

        requirementData require = tabRequirement.getSelectionModel().getSelectedItem();
        //fieldJobID.setText(String.valueOf(require.getJobID()));
       fieldJob.setText(require.getJob());
       fieldPeriod.setText(require.getPeriod());
       fieldCountry.setText(require.getCountry());
       fieldJobAge.setText(require.getAge());
       fieldJobExp.setText(require.getExperience());
       fieldSalary.setText(String.valueOf(require.getSalary()));
       fieldNoVisa.setText(String.valueOf(require.getNoVisa()) );

//        appID.setText(String.valueOf(applicant.getApplicantId()));

    }
    public int checkAge(String age){
        int result=0;
        if(Objects.equals(age, "Below Thirty")){
            result=30;

        }
        else if(Objects.equals(age, "Below Fourty")){
            result=40;

        }
        else if(Objects.equals(age, "Below Fifty")){
            result=50;

        }
        else{
            result=60;
        }
return result;
    }
    ObservableList<Applicant> ApplicantList = FXCollections.observableArrayList();
    @FXML
    void seeSuggestions() {
        requirementData require = tabRequirement.getSelectionModel().getSelectedItem();
        String require1=fieldJobID.getText();
        String require2=fieldJobAge.getText();
        String require3=fieldJobExp.getText();
        String require4=fieldJob.getText();
        String require5="not yet";
        String require6=require.getGender();
        String require7=require.getJob();
        int value = checkAge(require2);
        System.out.println(require2);
        System.out.println(value);

        try {

            ResultSet rs = c.createStatement().executeQuery("select Fname,Lname,email,address,gender,religon,age,applicantID,mobile,passportum,passIssueDate,passExpDate,experience,field,placeOfBirth, nic,nationality from applicant where age<'"+value+"' AND gender='"+require6+"' AND status='"+require5+"' ");
           // AND
            while (rs.next()) {
                ApplicantList.add(new Applicant(rs.getString("Fname"), rs.getString("Lname"), rs.getString("email"),
                        rs.getString("address"), rs.getString("gender"), rs.getString("religon"),
                        rs.getInt("age"), rs.getInt("applicantID"), rs.getString("mobile"),
                        rs.getString("passportum"), rs.getString("passIssueDate"), rs.getString("passExpDate"),
                        rs.getString("experience"), rs.getString("field"), rs.getString("placeOfBirth"), rs.getString("nic"), rs.getString("nationality")));
            }
            colFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            colLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
            colGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
            colReligon.setCellValueFactory(new PropertyValueFactory<>("Religon"));
            colAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
            colApplicantID.setCellValueFactory(new PropertyValueFactory<>("ApplicantId"));
            colContact.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
            colPassportNum.setCellValueFactory(new PropertyValueFactory<>("PassportNum"));
            colDateOfIssue.setCellValueFactory(new PropertyValueFactory<>("PassportISsue"));
            colDateofExp.setCellValueFactory(new PropertyValueFactory<>("Passportexp"));
            //colExperience.setCellValueFactory(new PropertyValueFactory<>("Experience"));
            colPlace.setCellValueFactory(new PropertyValueFactory<>("Place"));
            colNic.setCellValueFactory(new PropertyValueFactory<>("Nic"));
            colField.setCellValueFactory(new PropertyValueFactory<>("Field"));
            colExperience.setCellValueFactory( new PropertyValueFactory<>("Experience"));
            colNationality.setCellValueFactory(new PropertyValueFactory<>("Nationality"));

            table.setItems(ApplicantList);





        } catch (SQLException ex) {
            Logger.getLogger(viewApplicantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }





//    @FXML
//    public void Delete(ActionEvent event) {
//        String sql = "delete from applicant where applicantID = ?";
//        try {
//            pst = c.prepareStatement(sql);
//            pst.setInt(1, Integer.parseInt(appID.getText()));
//            int i = pst.executeUpdate();
//            if (i == 1) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Success");
//                alert.setHeaderText("Employee Details");
//                alert.setContentText("Employee Details Deleted Successfully");
//                alert.showAndWait();
////                EmployeeCount();
//                refresh();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//

    public void refresh() {
        requirements.clear();
        loadRequirements();
    }
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ObservableList<String> religons= FXCollections.observableArrayList("Buddhism","Christianity","Hinduism","Islam");
//        religonChooser.setItems(religons);
//        ObservableList<String> gender=FXCollections.observableArrayList("Male","Female","Other");
//        genderChooser.setItems(gender);
//        ObservableList<String>nationalities=FXCollections.observableArrayList("Sri Lankan","Other");
//        nationalityChooser.setItems(nationalities);
//        ObservableList<String>fields=FXCollections.observableArrayList("Cheff","Cooking","Cleaners","Co-Worker","Driving","House maids","Janitor","Security","Shop keeper");
//        fieldChooser.setItems(fields);
//        ObservableList<Integer>ages=FXCollections.observableArrayList(18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,1,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57);
//        ageChooser.setItems(ages);
        Connect();
        loadRequirements();
        AlertCount();

    }


    public void assignButton(ActionEvent event) {
        try{
            String value1=applicantID.getText();
            String value2="assigned";



            String sql="update applicant set status='"+value2+"'  where applicant.applicantID='"+value1+"' " ;
            pst = c.prepareStatement(sql);
            int a = pst.executeUpdate();
            if(a==1)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Applicant Details");
                alert.setContentText("Applicant Assigned Successfully");
                alert.showAndWait();
                refreshApplicants();

                fieldFirstName.setText("");
                fieldLastName.setText("");
                fieldAge.setText("");
                fieldEmail.setText("");
                fieldContact.setText("");
                filedReligon.setText("");
                fieldField.setText("");
                fieldGender.setText("");
                imgView.setImage(null);
            }
        }catch (Exception e){
            System.out.println(e);

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
