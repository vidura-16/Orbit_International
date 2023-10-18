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
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AnnouncementController implements Initializable {

    @FXML
    private ChoiceBox<String> topicChooser;

    @FXML
    private Label dateLabel;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TextField txtTopic;

    @FXML
    private TextArea txtAnnouncement;

    @FXML
    private Label choiceLabel;

    @FXML
    private TextField SearchBar;

    @FXML
    private Label IDlabel;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button submitButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button viewButton;

    @FXML
    private Button addButton;

    @FXML
    private DatePicker date;

    @FXML
    private TableView<data> table;

    @FXML
    private TableColumn<data, String> topicCol;

    @FXML
    private TableColumn<data, String> annouCol;

    @FXML
    private TableColumn<data, String> dateCol;

    @FXML
    private TableColumn<data, String> visibilityCol;

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

    int index = -1;

    //database connection
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
    private Button btnviewMore;

    public void view() throws IOException {
        if(txtTopic.getText().isBlank() == false && txtAnnouncement.getText().isBlank() == false){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewMoreAnnouncement.fxml"));
        Parent root = (Parent) loader.load();

        ViewMoreController viewMoreController = loader.getController();
        viewMoreController.viewMore(txtTopic.getText(),txtAnnouncement.getText(),dateLabel.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage = (Stage) btnviewMore.getScene().getWindow();

        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Announcement");
            alert.setHeaderText("Announcement");
            alert.setContentText("Announcement can't view");
            alert.showAndWait();
        }

    }


    public void ViewMore(ActionEvent event) throws IOException {
            view();
    }
    @FXML
    void submitButtonAction(ActionEvent event) {
        Connect();

        validateTopic();
        validateAnnouncement();
        validateDate();
        validateVisibility();
        String announcement = txtAnnouncement.getText();
        String topic = txtTopic.getText();
        String date = dateLabel.getText();
        String visibility = choiceLabel.getText();

        try {

            if(txtTopic.getText().isBlank() == false && txtAnnouncement.getText().isBlank() == false && dateLabel.getText().isBlank() == false && choiceLabel.getText().isBlank() == false) {
                pst = c.prepareStatement("insert into announcement(announcement,date,visibility,topic) values(?,?,?,?)");
                pst.setString(1, announcement);
                pst.setString(2, date);
                pst.setString(3, visibility);
                pst.setString(4, topic);
                int status = pst.executeUpdate();

                if (status == 1) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Announcement");
                    alert.setHeaderText("Announcement");
                    alert.setContentText("Announcement Added Successfully");
                    alert.showAndWait();
                    txtTopic.setText("");
                    txtAnnouncement.setText("");
                    choiceBox.setValue(null);
                    datepicker.getEditor().clear();
                    topicCheck1.setSelected(false);
                    topicCheck2.setSelected(false);
                    topicCheck3.setSelected(false);
                    topicCheck4.setSelected(false);
                    refreshTable();
                }
                } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Announcement");
                alert.setHeaderText("Announcement");
                alert.setContentText("Announcement Added failed");
                alert.showAndWait();
                }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
//validation

    @FXML
    private Label visibilityAlertLabel;

    @FXML
    private Label dateAlertLabel;

    public void validateTopic() {
        if (txtTopic.getText().isEmpty()) {
            txtTopic.setStyle("-fx-border-color: red; -fx-border-width: 1px ");
        } else{
            txtTopic.setStyle(null);
        }
    }

    public void validateAnnouncement() {
        if (txtAnnouncement.getText().isEmpty()) {
            txtAnnouncement.setStyle("-fx-border-color: red; -fx-border-width: 1px ");
        } else{
            txtAnnouncement.setStyle(null);
        }
    }

    public void validateVisibility() {
        if (choiceLabel.getText().isEmpty()) {
            choiceBox.setStyle("-fx-border-color: red; -fx-border-width: 1px");
        } else {
            choiceBox.setStyle("");
        }
    }

    public void validateDate() {
        if (dateLabel.getText().isEmpty()) {
            datepicker.setStyle("-fx-border-color: red; -fx-border-width: 1px");
        } else {
            datepicker.setStyle("");
        }
    }


    public void clear(ActionEvent event) {
        txtAnnouncement.setText("");
        txtTopic.setText("");
        choiceBox.setValue(null);
        datepicker.getEditor().clear();
    }

    public void getDate(ActionEvent event) {
        LocalDate myDate = datepicker.getValue();
        String FormattedDate=myDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        dateLabel.setText(FormattedDate);
    }

    @FXML
    private CheckBox topicCheck1;

    @FXML
    void setTopic1(ActionEvent event) {
        if(topicCheck1.isSelected()){
            txtTopic.setText("Meeting");
        }else{
            txtTopic.setText("");
        }

    }
    @FXML
    private CheckBox topicCheck2;

    @FXML
    void setTopic2(ActionEvent event) {
        if(topicCheck2.isSelected()){
            txtTopic.setText("Event");
        }else{
            txtTopic.setText("");
        }

    }
    @FXML
    private CheckBox topicCheck3;

    @FXML
    void setTopic3(ActionEvent event) {
        if(topicCheck3.isSelected()){
            txtTopic.setText("Special Event");
        }else{
            txtTopic.setText("");
        }

    }
    @FXML
    private CheckBox topicCheck4;

    @FXML
    void setTopic4(ActionEvent event) {
        if(topicCheck4.isSelected()){
            txtTopic.setText("Quick Notice");
        }else{
            txtTopic.setText("");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connect();
        tableview();

        choiceBox.getItems().addAll(visibility);
        choiceBox.setOnAction(this::getVisibility);


    }

    private String[] visibility = {"For All","Only for Senior Employee","Only for Employee"};

    private String[] topic = {"Meeting" ,"Special Event"};

    @FXML
    private Label topicLabel;

    public void getVisibility(ActionEvent event){
        String theVisibility = choiceBox.getValue();
        choiceLabel.setText(theVisibility);
    }

    ObservableList<data> records = FXCollections.observableArrayList();

    public void tableview(){

        try {
            pst = c.prepareStatement("select announcement,date,visibility,topic from announcement");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    data record = new data();
                    record.setTopic(rs.getString("topic"));
                    record.setAnnouncement(rs.getString("announcement"));
                    record.setDate(rs.getString("date"));
                    record.setVisibility(rs.getString("visibility"));
                    records.add(record);

                }
            }
            table.setItems(records);
            topicCol.setCellValueFactory(f -> f.getValue().topicProperty());
            annouCol.setCellValueFactory(f -> f.getValue().announcementProperty());
            dateCol.setCellValueFactory(f -> f.getValue().dateProperty());
            visibilityCol.setCellValueFactory(f -> f.getValue().visibilityProperty());
        } catch (SQLException ex) {
            Logger.getLogger(AnnouncementController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //search
        FilteredList<data> filteredData = new FilteredList<>(records, b-> true);
        SearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(data -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (data.getTopic().toLowerCase().indexOf(searchKeyword) > -1 ){
                    return true;
                }else if (data.getAnnouncement().toLowerCase().indexOf(searchKeyword) > -1 ){
                    return true;
                }else if (data.getDate().toLowerCase().indexOf(searchKeyword) > -1 ){
                    return true;
                }else if (data.getVisibility().toLowerCase().indexOf(searchKeyword) > -1 ){
                    return true;
                }else {
                    return false;
                }
            });

        });

        SortedList<data> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    public void selectRow(javafx.scene.input.MouseEvent mouseEvent) {
        index = table.getSelectionModel().getFocusedIndex();
        if(index <= -1){
            return;
        }
        txtTopic.setText(topicCol.getCellData(index).toString());
        txtAnnouncement.setText(annouCol.getCellData(index).toString());
        choiceBox.setValue(visibilityCol.getCellData(index).toString());
        datepicker.setPromptText(dateCol.getCellData(index).toString());
        dateLabel.setText(dateCol.getCellData(index).toString());
        //datepicker.setValue(LocalDate.parse(dateCol.getCellData(index)));

    }


    public void Edit(ActionEvent event){

        try{
            Connect();

            String cell1 = txtTopic.getText();
            String cell2 = txtAnnouncement.getText();
            String cell3 = dateLabel.getText();
            String cell4 = choiceLabel.getText();

            if(txtTopic.getText().isBlank() == false && txtAnnouncement.getText().isBlank() == false && dateLabel.getText().isBlank() == false && choiceLabel.getText().isBlank() == false) {


                String sql = "update announcement set announcement='" + cell2 + "',topic='" + cell1 + "',date='" + cell3 + "',visibility='" + cell4 + "' where topic='" + cell1 + "' ";

                pst = c.prepareStatement(sql);
                pst.execute();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Announcement");
                alert.setHeaderText("Announcement");
                alert.setContentText("Announcement updated Successfully");
                alert.showAndWait();
                txtTopic.setText("");
                txtAnnouncement.setText("");
                choiceBox.setValue(null);
                datepicker.getEditor().clear();
                refreshTable();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Announcement");
                alert.setHeaderText("Announcement");
                alert.setContentText("Announcement Added failed");
                alert.showAndWait();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Announcement");
            alert.setHeaderText("Announcement");
            alert.setContentText("Announcement update failed");
            alert.showAndWait();
            txtTopic.setText("");
            txtAnnouncement.setText("");
            choiceBox.setValue(null);
            datepicker.getEditor().clear();
        }
    }

    //delete data
    public void Delete(ActionEvent event){
        try{
            Connect();

            String cell1 = txtTopic.getText();
            String cell2 = txtAnnouncement.getText();
            String cell3 = dateLabel.getText();
            String cell4 = choiceLabel.getText();

            String sql = "delete from announcement where topic='"+cell1+"' AND announcement='"+cell2+"'";

            pst = c.prepareStatement(sql);
            pst.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Announcement");
            alert.setHeaderText("Announcement");
            alert.setContentText("Announcement deleted Successfully");
            alert.showAndWait();
            txtTopic.setText("");
            txtAnnouncement.setText("");
            choiceBox.setValue(null);
            datepicker.getEditor().clear();
            refreshTable();

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Announcement");
            alert.setHeaderText("Announcement");
            alert.setContentText("Announcement delete failed");
            alert.showAndWait();
            txtTopic.setText("");
            txtAnnouncement.setText("");
            choiceBox.setValue(null);
            datepicker.getEditor().clear();
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

    public void refreshTable(){
        records.clear();

        try {
            pst = c.prepareStatement("select announcement,date,visibility,topic from announcement");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    data record = new data();
                    record.setTopic(rs.getString("topic"));
                    record.setAnnouncement(rs.getString("announcement"));
                    record.setDate(rs.getString("date"));
                    record.setVisibility(rs.getString("visibility"));
                    records.add(record);
                }
            }
            table.setItems(records);
            topicCol.setCellValueFactory(f -> f.getValue().topicProperty());
            annouCol.setCellValueFactory(f -> f.getValue().announcementProperty());
            dateCol.setCellValueFactory(f -> f.getValue().dateProperty());
            visibilityCol.setCellValueFactory(f -> f.getValue().visibilityProperty());
        } catch (SQLException ex) {
            Logger.getLogger(AnnouncementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}