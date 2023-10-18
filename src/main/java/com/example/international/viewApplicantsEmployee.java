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
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class viewApplicantsEmployee  implements Initializable {

    public Label labelTot;

    public TextField txtKeyword;

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
    private Button btnUpdate;

    @FXML
    private Button btnAddEmployee;

    @FXML
    private Label txtCount;


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
    private ImageView imgView;

    @FXML
    private Button UpdateButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Label appID;

    @FXML
    private ImageView dspImage;

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
    void AddApplicant(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("ApplicantEmployee.fxml"));
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
    void LeaveRequest(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("ApplyLeaveEmployee.fxml"));
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
    void ToDo(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("ViewTaskEmployee.fxml"));
        Stage window= (Stage) btnToDo.getScene().getWindow();
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
        Parent root=FXMLLoader.load(getClass().getResource("EmployeeDash.fxml"));
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
    void showAlerts(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("Alert-Employee.fxml"));
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
    void viewApplicant(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("viewAllApplicantsEmployee.fxml"));
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

    ObservableList<Applicant> ApplicantList = FXCollections.observableArrayList();

    Connection c;

    @FXML
    private Button btnMails;

    @FXML
    private Button btnAddtask;

    @FXML
    private Button btnViewEmployee;

    @FXML
    private Button btnRequirements;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Connect();
        loadData();
        AlertCount();
    }

    public void loadData() {
        try {

            ResultSet rs = c.createStatement().executeQuery("select * from applicant");
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



            FilteredList<Applicant> filteredData = new FilteredList<>(ApplicantList, b -> true);

            txtKeyword.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(Applicant -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }
                    String searchkeyword = newValue.toLowerCase();

                    if (Applicant.getFirstName().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;
                    } else if (Applicant.getLastName().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;
                    } else if (Applicant.getGender().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;
                    } else if (Applicant.getEmail().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;
                    } else {
                        return false;
                    }
                });
            });

            SortedList<Applicant> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(table.comparatorProperty());

            table.setItems(sortedData);

        } catch (SQLException ex) {
            Logger.getLogger(viewApplicantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Update(){
        try{
            String value1=fieldFirstName.getText();
            String value2=fieldLastName.getText();
            String value3=fieldEmail.getText();
            int value4= Integer.parseInt(fieldAge.getText());
            String value=filedReligon.getText();
            String value5=fieldContact.getText();
            LocalDate value6=fieldDateofIssue.getValue();
            LocalDate value7=fieldDateofEx.getValue();
            String value8=fieldPassnum.getText();
            String value9=filedNA.getText();
            String value10=fieldNIC.getText();
            String value11=fieldAddress.getText();
            String value12=fieldGender.getText();
            String value13=fieldPlace.getText();
            String value14=fieldField.getText();
            String value15=fielldExperience.getText();
            String value16=appID.getText();


            String sql="update applicant set Fname='"+value1+"', Lname='"+value2+"',email='"+value3+"',age='"+value4+"', religon='"+value5+"', passIssueDate='"+value6+"',passExpDate='"+value7+"',passportum='"+value8+"', nationality='"+value9+"',nic='"+value10+"', address='"+value11+"', gender='"+value12+"', placeOfBirth='"+value13+"' , field ='"+value14+"', experience='"+value15+"'  where applicant.applicantID='"+value16+"' " ;
            pst = c.prepareStatement(sql);
            int a = pst.executeUpdate();
            if(a==1)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Applicant Details");
                alert.setContentText("Applicant Details Updated Successfully");
                alert.showAndWait();
                refresh();
                fieldFirstName.setText("");
                fieldLastName.setText("");
                fieldEmail.setText("");
                fieldAge.setText("");
                filedReligon.setText("");
                fieldContact.setText("");
                fieldDateofIssue.getEditor().clear();
                fieldDateofEx.getEditor().clear();
                fieldPassnum.setText("");
                filedNA.setText("");
                fieldNIC.setText("");
                fieldAddress.setText("");
                fieldGender.setText("");
                fieldPlace.setText("");
                fieldField.setText("");
                fielldExperience.setText("");
                appID.setText("");
            }
        }catch (Exception e){
            System.out.println(e);

        }
    }


    @FXML
    void showMedicalReport(ActionEvent event) {
        try{
            String id=fieldNIC.getText();
            ResultSet rs = c.createStatement().executeQuery("select medical from applicant  where nic ='"+id+"'");
            if(rs.next()){
                Blob blob=rs.getBlob(1);
                InputStream inputStream=blob.getBinaryStream();
                Image image=new Image(inputStream);
                dspImage.setImage(image);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void showProfileImg(ActionEvent event) {
        try{
            String id=fieldNIC.getText();
            ResultSet rs = c.createStatement().executeQuery("select img from applicant  where nic ='"+id+"'");
            if(rs.next()){
                Blob blob=rs.getBlob(1);
                InputStream inputStream=blob.getBinaryStream();
                Image image=new Image(inputStream);
                dspImage.setImage(image);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

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
        fieldNIC.setText(applicant.getNic());
        fieldPassnum.setText(applicant.getPassportNum());
        fieldDateofIssue.setPromptText(applicant.getPassportISsue());
        fieldDateofEx.setPromptText(applicant.getPassportexp());
        filedNA.setText(applicant.getNationality());
        fieldField.setText(applicant.getField());
        fielldExperience.setText(applicant.getExperience());
        fieldAddress.setText(applicant.getAddress());
        fieldGender.setText(applicant.getGender());
        fieldPlace.setText(applicant.getPlace());
        fieldField.setText(applicant.getField());
        fielldExperience.setText(applicant.getExperience());
        appID.setText(String.valueOf(applicant.getApplicantId()));

    }

    @FXML
    public void Delete(ActionEvent event) {
        String sql = "delete from applicant where applicantID = ?";
        try {
            pst = c.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(appID.getText()));
            int i = pst.executeUpdate();
            if (i == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Employee Details");
                alert.setContentText("Employee Details Deleted Successfully");
                alert.showAndWait();

                refresh();
                fieldFirstName.setText("");
                fieldLastName.setText("");
                fieldEmail.setText("");
                fieldAge.setText("");
                filedReligon.setText("");
                fieldContact.setText("");
                fieldDateofIssue.getEditor().clear();
                fieldDateofEx.getEditor().clear();
                fieldPassnum.setText("");
                filedNA.setText("");
                fieldNIC.setText("");
                fieldAddress.setText("");
                fieldGender.setText("");
                fieldPlace.setText("");
                fieldField.setText("");
                fielldExperience.setText("");
                appID.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//

    public void refresh() {
        ApplicantList.clear();
        loadData();
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



