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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alert_SeniorEmployeeController implements Initializable {

    @FXML
    private TableView<data> table;

    @FXML
    private TableColumn<data, String> topicCol;

    @FXML
    private TableColumn<data, String> annouCol;

    @FXML
    private TableColumn<data, String> dateCol;

    @FXML
    private TextField searchBar;

    @FXML
    private Label alertLabel;

    @FXML
    private Label Dalertlabel;

    @FXML
    private Label AlertCountLabel;

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
    private Button searchButton;

    @FXML
    private CheckBox topicCheck1;

    @FXML
    private CheckBox topicCheck2;

    @FXML
    private CheckBox topicCheck3;

    @FXML
    private CheckBox topicCheck4;

    public void setTopic1(ActionEvent actionEvent){
        ObservableList<data> records = FXCollections.observableArrayList();
        try {
            pst = c.prepareStatement("select announcement,date,visibility,topic from announcement where `topic` ='Meeting' AND `visibility` IN('Only for Senior Employee','For All')");
            ResultSet rs = pst.executeQuery();
            {
                int count = 0;
                while (rs.next()) {
                    data record = new data();
                    record.setTopic(rs.getString("topic"));
                    record.setAnnouncement(rs.getString("announcement"));
                    record.setDate(rs.getString("date"));
                    records.add(record);
                    count++;
                    alertLabel.setText(String.valueOf(count));
                    //Dalertlabel.setText(String.valueOf(count));

                }
            }
            table.setItems(records);
            topicCol.setCellValueFactory(f -> f.getValue().topicProperty());
            annouCol.setCellValueFactory(f -> f.getValue().announcementProperty());
            dateCol.setCellValueFactory(f -> f.getValue().dateProperty());

        } catch (SQLException ex) {
            Logger.getLogger(AnnouncementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FilteredList<data> filteredData = new FilteredList<>(records, b-> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
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
                }else {
                    return false;
                }
            });

        });

        SortedList<data> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    public void setTopic2(ActionEvent actionEvent){
        ObservableList<data> records = FXCollections.observableArrayList();
        try {
            pst = c.prepareStatement("select announcement,date,visibility,topic from announcement where `topic` ='Event' AND `visibility` IN('Only for Senior Employee','For All')");
            ResultSet rs = pst.executeQuery();
            {
                int count = 0;
                while (rs.next()) {
                    data record = new data();
                    record.setTopic(rs.getString("topic"));
                    record.setAnnouncement(rs.getString("announcement"));
                    record.setDate(rs.getString("date"));
                    records.add(record);
                    count++;
                    alertLabel.setText(String.valueOf(count));
                    //Dalertlabel.setText(String.valueOf(count));

                }
            }
            table.setItems(records);
            topicCol.setCellValueFactory(f -> f.getValue().topicProperty());
            annouCol.setCellValueFactory(f -> f.getValue().announcementProperty());
            dateCol.setCellValueFactory(f -> f.getValue().dateProperty());

        } catch (SQLException ex) {
            Logger.getLogger(AnnouncementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FilteredList<data> filteredData = new FilteredList<>(records, b-> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
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
                }else {
                    return false;
                }
            });

        });

        SortedList<data> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    public void setTopic3(ActionEvent actionEvent){
        ObservableList<data> records = FXCollections.observableArrayList();
        try {
            pst = c.prepareStatement("select announcement,date,visibility,topic from announcement where `topic` ='Special Event' AND `visibility` IN('Only for Senior Employee','For All')");
            ResultSet rs = pst.executeQuery();
            {
                int count = 0;
                while (rs.next()) {
                    data record = new data();
                    record.setTopic(rs.getString("topic"));
                    record.setAnnouncement(rs.getString("announcement"));
                    record.setDate(rs.getString("date"));
                    records.add(record);
                    count++;
                    alertLabel.setText(String.valueOf(count));
                    //Dalertlabel.setText(String.valueOf(count));

                }
            }
            table.setItems(records);
            topicCol.setCellValueFactory(f -> f.getValue().topicProperty());
            annouCol.setCellValueFactory(f -> f.getValue().announcementProperty());
            dateCol.setCellValueFactory(f -> f.getValue().dateProperty());

        } catch (SQLException ex) {
            Logger.getLogger(AnnouncementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FilteredList<data> filteredData = new FilteredList<>(records, b-> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
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
                }else {
                    return false;
                }
            });

        });

        SortedList<data> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    public void setTopic4(ActionEvent actionEvent){
        ObservableList<data> records = FXCollections.observableArrayList();
        try {
            pst = c.prepareStatement("select announcement,date,visibility,topic from announcement where `topic` ='Quick Notice' AND `visibility` IN('Only for Senior Employee','For All')");
            ResultSet rs = pst.executeQuery();
            {
                int count = 0;
                while (rs.next()) {
                    data record = new data();
                    record.setTopic(rs.getString("topic"));
                    record.setAnnouncement(rs.getString("announcement"));
                    record.setDate(rs.getString("date"));
                    records.add(record);
                    count++;
                    alertLabel.setText(String.valueOf(count));
                    //Dalertlabel.setText(String.valueOf(count));

                }
            }
            table.setItems(records);
            topicCol.setCellValueFactory(f -> f.getValue().topicProperty());
            annouCol.setCellValueFactory(f -> f.getValue().announcementProperty());
            dateCol.setCellValueFactory(f -> f.getValue().dateProperty());

        } catch (SQLException ex) {
            Logger.getLogger(AnnouncementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FilteredList<data> filteredData = new FilteredList<>(records, b-> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
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
                }else {
                    return false;
                }
            });

        });

        SortedList<data> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    @FXML
    public void searchReset(javafx.scene.input.MouseEvent mouseEvent)  {
        ObservableList<data> records = FXCollections.observableArrayList();
        try {
            pst = c.prepareStatement("select announcement,date,visibility,topic from announcement where `visibility` IN('Only for Senior Employee','For All')");
            ResultSet rs = pst.executeQuery();
            {
                int count = 0;
                while (rs.next()) {
                    data record = new data();
                    record.setTopic(rs.getString("topic"));
                    record.setAnnouncement(rs.getString("announcement"));
                    record.setDate(rs.getString("date"));
                    records.add(record);
                    count++;
                    alertLabel.setText(String.valueOf(count));
                    //Dalertlabel.setText(String.valueOf(count));

                }
            }
            table.setItems(records);
            topicCol.setCellValueFactory(f -> f.getValue().topicProperty());
            annouCol.setCellValueFactory(f -> f.getValue().announcementProperty());
            dateCol.setCellValueFactory(f -> f.getValue().dateProperty());

        } catch (SQLException ex) {
            Logger.getLogger(AnnouncementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FilteredList<data> filteredData = new FilteredList<>(records, b-> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
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
                }else {
                    return false;
                }
            });

        });

        SortedList<data> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    @FXML
    void OnActionAddApplicant(ActionEvent event) throws IOException{
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
    void viewMails(ActionEvent event) throws IOException {
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

    //database connection
    Connection c;
    PreparedStatement pst;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/orbit", "root", "");
            System.out.println("Connection succeed");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }
    }

    //view data in table
    ObservableList<data> records = FXCollections.observableArrayList();

    public void table() {
        ObservableList<data> records = FXCollections.observableArrayList();
        try {
            pst = c.prepareStatement("select announcement,date,visibility,topic from announcement where `visibility` IN('Only for Senior Employee','For All')");
            ResultSet rs = pst.executeQuery();
            {
                int count = 0;
                while (rs.next()) {
                    data record = new data();
                    record.setTopic(rs.getString("topic"));
                    record.setAnnouncement(rs.getString("announcement"));
                    record.setDate(rs.getString("date"));
                    records.add(record);
                    count++;
                    alertLabel.setText(String.valueOf(count));
                    AlertCountLabel.setText(String.valueOf(count));


                }
            }
            table.setItems(records);
            topicCol.setCellValueFactory(f -> f.getValue().topicProperty());
            annouCol.setCellValueFactory(f -> f.getValue().announcementProperty());
            dateCol.setCellValueFactory(f -> f.getValue().dateProperty());
        } catch (SQLException ex) {
            Logger.getLogger(AnnouncementController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //search
        FilteredList<data> filteredData = new FilteredList<>(records, b-> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
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
                }else {
                    return false;
                }
            });

        });

        SortedList<data> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connect();
        table();

    }
    @FXML
    private Label txtUsernameLogin;

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

    int index = -1;

    public void selectRow(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        index = table.getSelectionModel().getFocusedIndex();
        if(index <= -1){
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewMoreAnnouncement.fxml"));
        Parent root = (Parent) loader.load();

        ViewMoreController viewMoreController = loader.getController();
        viewMoreController.viewMore(topicCol.getCellData(index).toString(),annouCol.getCellData(index).toString(),dateCol.getCellData(index).toString());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}





