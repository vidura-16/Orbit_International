package com.example.international;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;

public class Accounts {

    @FXML
    private Text lblExpenses;

    @FXML
    private Text lblincom;

    @FXML
    private Text lblprofit;

    @FXML
    private TextField txt;

    @FXML
    private TextField txtAcc;

    @FXML
    private TextField txtBureau;

    @FXML
    private TextField txtElectricity;

    @FXML
    private TextField txtMedical;

    @FXML
    private TextField txtOther;

    @FXML
    private TextField txtWater;

    @FXML
    private TextField txtincom;

    @FXML
    private TextField txttelephone;

    @FXML
    private TextField txtCommis;

    @FXML
    private TextField txtEmpSal;

    @FXML
    private Label lblacc;

    @FXML
    private Label lblelectric;

    @FXML
    private Label lblother;

    @FXML
    private Label lbltelephone;

    @FXML
    private Label lblwater;

    @FXML
    private Button btnDash;

    @FXML
    private Button btnViewSalary;

    @FXML
    private Button btnEmployeeSalary;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnSlip;

    @FXML
    private Button btnAccounts;

    @FXML
    void AccountCal(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("Accounts.fxml"));
        Stage window= (Stage) btnAccounts.getScene().getWindow();
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
    void EmployeeSalary(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("Employee_Salary.fxml"));
        Stage window= (Stage) btnEmployeeSalary.getScene().getWindow();
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
    void Slip(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("Salary_slip.fxml"));
        Stage window= (Stage) btnSlip.getScene().getWindow();
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
    void viewEmployeeSalary(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("EmpSalUpDel.fxml"));
        Stage window= (Stage) btnViewSalary.getScene().getWindow();
        window.setScene(new Scene(root,1400,767));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setTitle("");

        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
    }


    Connection con;
    PreparedStatement pst;
    ResultSet rs;


    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/orbit", "root", "");
            System.out.println("Connection succeed");
        } catch (ClassNotFoundException | SQLException var2) {
            var2.printStackTrace();
            System.out.println("Connection failed");
        }

    }

    public void TotalIncome() {
        try {
            this.Connect();
            pst = con.prepareStatement("SELECT SUM(price) AS totalIncome FROM jobs");
            ResultSet r = pst.executeQuery();
            while (r.next()) {
                int sumofincome = r.getInt("totalIncome");

                txtincom.setText(String.valueOf(sumofincome));

            }
        } catch (SQLException ex) {

        }
    }

    public void TotalMedicalExpense() {
        try {
            this.Connect();
            pst = con.prepareStatement("SELECT SUM(medicalCost) AS totalMedical FROM applicant");
            ResultSet r = pst.executeQuery();
            while (r.next()) {
                int sumofmedical = r.getInt("totalMedical");
                txtMedical.setText(String.valueOf(sumofmedical));

            }
        } catch (SQLException ex) {

        }
    }

    public void TotalBureauExpense() {
        try {
            this.Connect();
            pst = con.prepareStatement("SELECT SUM(bureau) AS totalBureau FROM applicant");
            ResultSet r = pst.executeQuery();
            while (r.next()) {
                int sumofbureau = r.getInt("totalBureau");

                txtBureau.setText(String.valueOf(sumofbureau));
            }
        } catch (SQLException ex) {

        }
    }

    public void TotalCommisExpense() {
        try {
            this.Connect();
            pst = con.prepareStatement("SELECT SUM(commission) AS totalCommis FROM applicant");
            ResultSet r = pst.executeQuery();
            while (r.next()) {
                int sumofcommis = r.getInt("totalCommis");
                txtCommis.setText(String.valueOf(sumofcommis));

            }
        } catch (SQLException ex) {

        }
    }
    public void TotalEmployeeSalary() {
        try {
            this.Connect();
            pst = con.prepareStatement("SELECT SUM(total) AS totalEmpSalary FROM empsalary");
            ResultSet r = pst.executeQuery();
            while (r.next()) {
                int sumofempsalary= r.getInt("totalEmpSalary");
                txtEmpSal.setText(String.valueOf(sumofempsalary));

            }
        } catch (SQLException ex) {

        }
    }


    public void CalculateAccount() {
        TotalIncome();
        TotalMedicalExpense();
        TotalCommisExpense();
        TotalBureauExpense();
        TotalEmployeeSalary();

        ElectricityValidate();
        WaterValidate();
        TelephoneValidate();
        AccesoriesValidate();


        int income = Integer.parseInt(txtincom.getText());
        int water = Integer.parseInt(txtWater.getText());
        int electric = Integer.parseInt(txtElectricity.getText());
        int telephone = Integer.parseInt(txttelephone.getText());
        int accessories = Integer.parseInt(txtAcc.getText());
        int other = Integer.parseInt(txtOther.getText());
        int medical = Integer.parseInt(txtMedical.getText());
        int bureau = Integer.parseInt(txtBureau.getText());
        int commis = Integer.parseInt(txtCommis.getText());
        int empsalary = Integer.parseInt(txtEmpSal.getText());


        int totalexpense = water + electric + telephone + accessories + other + medical + bureau + commis+empsalary;

        int profit = income - totalexpense;


        String c = String.valueOf(income);
        lblincom.setText(c);

        String d = String.valueOf(totalexpense);
        lblExpenses.setText(d);

        String e = String.valueOf(profit);
        lblprofit.setText(e);

    }


    public void save() {

        this.Connect();

        String value1 = this.txtincom.getText();
        String value2 = this.txtWater.getText();
        String value3 = this.txtElectricity.getText();
        String value4 = this.txttelephone.getText();
        String value5 = this.txtAcc.getText();
        String value6 = this.txtOther.getText();
        String value7 = this.txtMedical.getText();
        String value8 = this.txtBureau.getText();
        String value9 = this.txtCommis.getText();
        String value10 = this.lblincom.getText();
        String value11 = this.lblExpenses.getText();
        String value12 = this.lblprofit.getText();
        String value13 = this.lblprofit.getText();




        try {


                this.pst = this.con.prepareStatement("insert into income(sponsorPrice,water,electricity,telephone,accessories,commision,other,medical,bureau,empsal,income,expense,profit) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

                this.pst.setString(1, value1);
                this.pst.setString(2, value2);
                this.pst.setString(3, value3);
                this.pst.setString(4, value4);
                this.pst.setString(5, value5);
                this.pst.setString(6, value6);
                this.pst.setString(7, value7);
                this.pst.setString(8, value8);
                this.pst.setString(9, value9);
                this.pst.setString(10, value10);
                this.pst.setString(11, value11);
                this.pst.setString(12, value12);
                this.pst.setString(13, value13);


                int status = pst.executeUpdate();
                if (status == 1) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setTitle("Confirm");
                    alert.setHeaderText("Member");
                    alert.setContentText("Are you sure you want to save record?");
                    alert.showAndWait();

                    txtincom.setText("");
                    txtWater.setText("");
                    txtElectricity.setText("");
                    txttelephone.setText("");
                    txtAcc.setText("");
                    txtOther.setText("");
                    txtMedical.setText("");
                    txtBureau.setText("");
                    txtCommis.setText("");
                    lblincom.setText("");
                    lblExpenses.setText("");
                    lblprofit.setText("");
                    txtEmpSal.setText("");

                }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void ElectricityValidate() {
        if (txtElectricity.getText().isEmpty() ) {
            lblelectric.setText("Please enter a Electricity Bill amount");
        } else {
            lblelectric.setText("");
        }
    }

    public void WaterValidate() {
        if (txtWater.getText().isEmpty() ) {
            lblwater.setText("Please enter a Water Bill amount");
        } else {
            lblwater.setText("");
        }
    }

    public void TelephoneValidate() {
        if (txttelephone.getText().isEmpty() ) {
            lbltelephone.setText("Please enter a Telephone Bill amount");
        } else {
            lbltelephone.setText("");
        }
    }

    public void AccesoriesValidate() {
        if (txtAcc.getText().isEmpty() ) {
            lblacc.setText("Please enter a Accessories amount");
        } else {
            lblacc.setText("");
        }
    }




    public void logout(ActionEvent event) throws SQLException {
        String sql = "delete from activity";
        try {

            Connect();
            pst = con.prepareStatement(sql);
            int i = pst.executeUpdate();
            Stage stage = (Stage) btnLogout.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            primaryStage.setTitle("Manager");
            primaryStage.setScene(new Scene(root,900,600));
            primaryStage.show();


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }


}

