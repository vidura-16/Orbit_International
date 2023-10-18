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
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpSalaryUpdate implements Initializable {

    @FXML
    private TextField txtAllowance;

    @FXML
    private TextField txtBasicSalary;

    @FXML
    private TextField txtBonus;

    @FXML
    private TextField txtDeduction;

    @FXML
    private TextField txtEmpName;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtOT;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtTotal;

    @FXML
    private TextField txtreason;

    @FXML
    private TableColumn<EmployeeSal,Integer> ColAllo;

    @FXML
    private TableColumn<EmployeeSal,Integer> ColBS;

    @FXML
    private TableColumn<EmployeeSal,Integer> ColBonus;

    @FXML
    private TableColumn<EmployeeSal,Integer> ColDeduct;

    @FXML
    private TableColumn<EmployeeSal,Integer> ColID;

    @FXML
    private TableColumn<EmployeeSal, String> ColName;

    @FXML
    private TableColumn<EmployeeSal,Integer> ColOT;

    @FXML
    private TableColumn<EmployeeSal, String> ColReason;

    @FXML
    private TableColumn<EmployeeSal,Integer> ColTotal;

    @FXML
    private TableView<EmployeeSal> SalaryTable;

    @FXML
    private Button btnDash;

    @FXML
    private Button btnAccounts;

    @FXML
    private Button btnViewSalary;

    @FXML
    private Button btnEmployeeSalary;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnSlip;

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

    ObservableList<EmployeeSal> record = FXCollections.observableArrayList();

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

    public void SearchEmp(){
        try {
            Connect();

            String sq = "select empID, name, basicSalary, OT, allowance, bonus, deduction, reason,total from empsalary where empID=?";
            pst=con.prepareStatement(sq);
            pst.setString(1, txtSearch.getText());
            rs=pst.executeQuery();

            if(rs.next()) {

                String add1 = rs.getString("empID");
                txtID.setText(add1);

                String add2 = rs.getString("name");
                txtEmpName.setText(add2);

                String add3 = rs.getString("basicSalary");
                txtBasicSalary.setText(add3);

                String add4 = rs.getString("OT");
                txtOT.setText(add4);

                String add5 = rs.getString("allowance");
                txtAllowance.setText(add5);

                String add6 = rs.getString("bonus");
                txtBonus.setText(add6);

                String add7 = rs.getString("deduction");
                txtDeduction.setText(add7);

                String add8 = rs.getString("reason");
                txtreason.setText(add8);

                String add9 = rs.getString("total");
                txtTotal.setText(add9);

            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error");
            alert.showAndWait();

        }
        finally {
            try {
                rs.close();
                pst.close();
            }catch (Exception ex){

            }
        }
    }

    public void calculate(){
        int allowance = Integer.parseInt(txtAllowance.getText());
        int bonus = Integer.parseInt(txtBonus.getText());
        int deduction = Integer.parseInt(txtDeduction.getText());
        int salary = Integer.parseInt(txtBasicSalary.getText());
        int overtime = Integer.parseInt(txtOT.getText());
        double overtimeRate = 1000;

        double Total_Overtime = overtime * overtimeRate;
        double calc = salary + Total_Overtime+allowance+ bonus;
        double total = calc - deduction;
        String c = String.valueOf(total);
        txtTotal.setText(c);

    }

    public void update() throws SQLException {

        Connect();

        String value1 =  this.txtID.getText();
        String value2 =  this.txtEmpName.getText();
        String value3 =  this.txtBasicSalary.getText();
        String value4 =  this.txtOT.getText();
        String value5 =  this.txtAllowance.getText();
        String value6 =  this.txtBonus.getText();
        String value7 =  this.txtDeduction.getText();
        String value8 =  this.txtreason.getText();
        String value9 =  this.txtTotal.getText();

        String sql = "update empsalary set allowance='" + value5 + "',bonus='" + value6 + "',deduction='" + value7 + "',reason='" + value8 + "',total='" + value9+ "' where empID='" + value1 + "' ";
        this.pst = this.con.prepareStatement(sql);
        this.pst.execute();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Employee Details");
        alert.setContentText("Employee Details Update Successfully");
        alert.showAndWait();
        refresh();
        txtID.setText("");
        txtEmpName.setText("");
        txtBasicSalary.setText("");
        txtOT.setText("");
        txtAllowance.setText("");
        txtBonus.setText("");
        txtDeduction.setText("");
        txtreason.setText("");
        txtTotal.setText("");

    }

    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connect();
        table();
    }


   public void table() {

       try {
               ResultSet rs = con.createStatement().executeQuery("select * from empsalary");

               while (rs.next()) {

                   record.add(new EmployeeSal(rs.getInt("empID"),
                           rs.getString("name"),
                           rs.getInt("basicSalary"),
                           rs.getInt("OT"),
                           rs.getInt("allowance"),
                           rs.getInt("bonus"),
                           rs.getInt("deduction"),
                           rs.getString("deduction"),
                           rs.getInt("total")));

               }


               ColID.setCellValueFactory(new PropertyValueFactory<>("ID"));
               ColName.setCellValueFactory(new PropertyValueFactory<>("Name"));
               ColBS.setCellValueFactory(new PropertyValueFactory<>("BasicSalary"));
               ColOT.setCellValueFactory(new PropertyValueFactory<>("OT"));
               ColAllo.setCellValueFactory(new PropertyValueFactory<>("Allowance"));
               ColBonus.setCellValueFactory(new PropertyValueFactory<>("Bonus"));
               ColDeduct.setCellValueFactory(new PropertyValueFactory<>("Deduction"));
               ColReason.setCellValueFactory(new PropertyValueFactory<>("Reason"));
               ColTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));

               SalaryTable.setItems(record);

           } catch (SQLException ex) {
               Logger.getLogger(EmpSalaryUpdate.class.getName()).log(Level.SEVERE, null, ex);
           }

   }



    @FXML
    public void Delete() {

        try {
            String value1 =  this.txtID.getText();
            String value2 =  this.txtEmpName.getText();
            String value3 =  this.txtBasicSalary.getText();
            String value4 =  this.txtOT.getText();
            String value5 =  this.txtAllowance.getText();
            String value6 =  this.txtBonus.getText();
            String value7 =  this.txtDeduction.getText();
            String value8 =  this.txtreason.getText();
            String value9 =  this.txtTotal.getText();


            String sql = "delete from empsalary where  empID='" + value1 + "'AND name='" + value2 + "'AND basicSalary='" + value3 + "'AND OT='" + value4 + "'AND allowance='" + value5 + "'AND bonus='" + value6 + "'AND deduction='" + value7 + "'AND reason='" + value8 + "'AND total='" + value9+  "' ";
            this.pst = this.con.prepareStatement(sql);
            this.pst.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Employee Details");
                alert.setContentText("Employee Details Deleted Successfully");
                alert.showAndWait();
                refresh();
            txtID.setText("");
            txtEmpName.setText("");
            txtBasicSalary.setText("");
            txtOT.setText("");
            txtAllowance.setText("");
            txtBonus.setText("");
            txtDeduction.setText("");
            txtreason.setText("");
            txtTotal.setText("");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void refresh() {
        record.clear();
        table();

    }

    //--------------Navigation---------------------------



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
