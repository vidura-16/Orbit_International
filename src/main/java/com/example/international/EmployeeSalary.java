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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;

public class EmployeeSalary  {

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtEmpName;

    @FXML
    private TextField txtBasicSalary;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtOT;

    @FXML
    private TextField txtAllowance;

    @FXML
    private TextField txtBonus;

    @FXML
    private TextField txtDeduction;

    @FXML
    private TextField txtreason;

    @FXML
    private Text lblTotal;

    @FXML
    private Label lblallowance;

    @FXML
    private Label lblbonus;

    @FXML
    private Label lbldeduction;

    @FXML
    private AnchorPane btn;

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
    private Button btnCalculate;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblallowance1;

    @FXML
    void AccountCal(ActionEvent event) throws IOException{
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
    void EmployeeSalary(ActionEvent event) throws IOException{
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
    void Slip(ActionEvent event) throws IOException{
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

    //-------------------DB Connection -------------------------------------------------------------------------------------------------

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

    //-------------------------Salary Calculation -------------------------------------------------------------------------------------------------


    @FXML
    protected void onHelloButtonClick() {
        AllowanceValidate();
        BonusValidate();
        DeductionValidate();

        int salary = Integer.parseInt(txtBasicSalary.getText());
        int overtime = Integer.parseInt(txtOT.getText());
        int deduction = Integer.parseInt(txtDeduction.getText());



        double eight = 8;
        double days = 25;
        double dbop = 0;
        double overtimeRate = 1000;

        double Total_Overtime = overtime * overtimeRate;
        String x = String.valueOf(Total_Overtime);


        //calculate overall overtime
        dbop = salary / days / eight;
        String s = String.valueOf(dbop);


        int allowance = Integer.parseInt(txtAllowance.getText());
        int bonus = Integer.parseInt(txtBonus.getText());


        double calc = salary + Total_Overtime+allowance+ bonus;
        double total = calc - deduction;
        String c = String.valueOf(total);
        lblTotal.setText(c);
    }


    // -------------------Insert to database ----------------------------------------------------------------------------------------------------

    @FXML
    protected void save(ActionEvent event) {


        this.Connect();

        String value1 =  this.txtID.getText();
        String value2 =  this.txtEmpName.getText();
        String value3 =  this.txtBasicSalary.getText();
        String value4 =  this.txtOT.getText();
        String value5 =  this.txtAllowance.getText();
        String value6 =  this.txtBonus.getText();
        String value7 =  this.txtDeduction.getText();
        String value8 =  this.txtreason.getText();
        String value9 =  this.lblTotal.getText();



        try {
            if (!this.txtID.getText().isBlank() && !this.txtEmpName.getText().isBlank() && !this.txtBasicSalary.getText().isBlank() && !this.txtOT.getText().isBlank() && !this.txtAllowance.getText().isBlank() && !this.txtBonus.getText().isBlank() && !this.txtDeduction.getText().isBlank()){

                this.pst = this.con.prepareStatement("insert into empsalary(empID,name,basicSalary,OT,allowance,bonus,deduction,reason,total) values(?,?,?,?,?,?,?,?,?)");

            this.pst.setString(1, value1);
            this.pst.setString(2, value2);
            this.pst.setString(3, value3);
            this.pst.setString(4, value4);
            this.pst.setString(5, value5);
            this.pst.setString(6, value6);
            this.pst.setString(7, value7);
            this.pst.setString(8, value8);
            this.pst.setString(9, value9);

            int status = pst.executeUpdate();
            if (status == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Confirm");
                alert.setHeaderText("Member");
                alert.setContentText("Are you sure you want to save record?");
                alert.showAndWait();

                txtID.setText("");
                txtEmpName.setText("");
                txtBonus.setText("");
                txtOT.setText("");
                txtBasicSalary.setText("");
                txtAllowance.setText("");
                txtDeduction.setText("");
                txtreason.setText("");
                lblTotal.setText("");
            }
        }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Error Message");
                alert.setHeaderText("Member");
                alert.setContentText("Failed");
                alert.showAndWait();

            }

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //Search Employee ------------------------------------------------------------------------------------------------------

    @FXML
    protected void search() {

        try {
            Connect();

            String sq = "SELECT employee.EmpID, employee.firstName, employee.salary, overtime.overTime FROM employee INNER JOIN overtime ON employee.EmpID=overtime.EmpID WHERE employee.EmpID=?";
            pst = con.prepareStatement(sq);
            pst.setString(1, txtSearch.getText());
            rs = pst.executeQuery();


            if (rs.next()) {

                String add1 = rs.getString("EmpID");
                txtID.setText(add1);

                String add2 = rs.getString("firstName");
                txtEmpName.setText(add2);

                String add3 = rs.getString("salary");
                txtBasicSalary.setText(add3);

                String add4 = rs.getString("overTime");
                txtOT.setText(add4);

            }

        } catch (Exception e) {

        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception ex) {

            }
        }
    }

    public void AllowanceValidate() {
        if (txtAllowance.getText().isEmpty() ||txtAllowance.getText().matches("[a-zA-Z_]+")) {
            lblallowance.setText("Please enter a valid amount");
        } else {
            lblallowance.setText("");
        }
    }

    public void BonusValidate() {
        if (txtBonus.getText().isEmpty() ||txtBonus.getText().matches("[a-zA-Z_]+") ) {
            lblbonus.setText("Please enter a valid amount");
        } else {
            lblbonus.setText("");
        }
    }

    public void DeductionValidate() {
        if (txtDeduction.getText().isEmpty() ||txtDeduction.getText().matches("[a-zA-Z_]+")) {
            lbldeduction.setText("Please enter a valid amount");
        } else {
            lbldeduction.setText("");
        }
    }





    //-------------------------------------Navigation-------------------------------------------------------------------------------


    @FXML
    void Logout(ActionEvent event) throws IOException, SQLException {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


