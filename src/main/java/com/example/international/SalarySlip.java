package com.example.international;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Date;


public class SalarySlip {

    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtEmpName;

    @FXML
    private TextField txtDesignation;

    @FXML
    private TextField txtPhone;

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
    private TextField txtTotal;

    private Object Document;

    @FXML
    private Button btnDash;

    @FXML
    private Button btnAccounts;

    @FXML
    private Button btnEmployeeSalary;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnSlip;

    @FXML
    private Button btnViewSalary;

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
    void SalarySlip(ActionEvent event) throws IOException {
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

    //--------------------------------search-----------------------------------------------------------------------------------------
    @FXML
    protected void searchemp() {

        Connect();

        try {
            String sql = "SELECT employee.EmpID,employee.telephoneNum,employee.status, empsalary.name, empsalary.basicSalary, empsalary.OT, empsalary.allowance, empsalary.bonus, empsalary.deduction,empsalary.total FROM employee INNER JOIN empsalary ON employee.EmpID=empsalary.EmpID WHERE employee.EmpID=? ";
            pst = con.prepareStatement(sql);
            pst.setString(1, txtSearch.getText());
            rs = pst.executeQuery();

            if (rs.next()) {


                String add1 = rs.getString("empID");
                txtID.setText(add1);

                String add2 = rs.getString("name");
                txtEmpName.setText(add2);

                String add3 = rs.getString("status");
                txtDesignation.setText(add3);

                String add4 = rs.getString("telephoneNum");
                txtPhone.setText(add4);


                String add5 = rs.getString("basicSalary");
                txtBasicSalary.setText(add5);

                String add6 = rs.getString("OT");
                txtOT.setText(add6);

                String add7 = rs.getString("allowance");
                txtAllowance.setText(add7);

                String add8 = rs.getString("bonus");
                txtBonus.setText(add8);

                String add9 = rs.getString("deduction");
                txtDeduction.setText(add9);

                String add10 = rs.getString("total");
                txtTotal.setText(add10);



            }
        } catch (Exception e) {


        }
        finally {
            try {
                rs.close();
                pst.close();
            }catch (Exception ex){

            }
        }
    }


//----------------------------------------PDF---------------------------------------------------------

           @FXML
            protected   void writeUsingIText() {

                Document myDocument = new Document();

                String value = txtID.getText();
                String value1 = txtEmpName.getText();
                String value2 = txtBasicSalary.getText();
                String value3 = txtOT.getText();
                String value4 = txtAllowance.getText();
                String value5 = txtBonus.getText();
                String value6 = txtDeduction.getText();
                String value7 = txtTotal.getText();
                String value8 = txtDesignation.getText();
                String value9= txtPhone.getText();

                final String FILE_NAME = "D:\\salaryPDF\\"+value1+"_Salary.pdf";

                try {


                 PdfWriter.getInstance(myDocument, new FileOutputStream(new File(FILE_NAME)));

                    myDocument.open();

                    myDocument.add(new Paragraph("PAY SLIP", FontFactory.getFont(FontFactory.TIMES_BOLD, 20, Font.BOLD)));
                    myDocument.add(new Paragraph(new Date().toString()));
                    myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                    myDocument.add((new Paragraph("EMPLOYEE DETAILS", FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD))));
                    myDocument.add((new Paragraph("Employee ID: " + value, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL))));
                    myDocument.add((new Paragraph("Name of Employee: " + value1, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL))));
                    myDocument.add((new Paragraph("Designation: " + value8, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL))));
                    myDocument.add((new Paragraph("Phone: " + value9, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL))));

                    myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                    myDocument.add(new Paragraph("SALARY", FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD)));
                    myDocument.add(new Paragraph("Basic Salary: Rs." + value2, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                    myDocument.add(new Paragraph("Overtime: " + value3, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                    myDocument.add(new Paragraph("Allowance: Rs." + value4, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                    myDocument.add(new Paragraph("Bonus: Rs." + value5, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));

                    myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                    myDocument.add(new Paragraph("DEDUCTION", FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD)));
                    myDocument.add(new Paragraph("Total Deductions : Rs." + value6, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                    myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                    myDocument.add(new Paragraph("TOTAL PAYMENT", FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD)));
                    myDocument.add(new Paragraph("Net Pay : " + value7, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                    myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));


                    myDocument.newPage();
                    myDocument.close();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setTitle("Confirm");
                    alert.setHeaderText("Member");
                    alert.setContentText("Do you want to export as pdf?");
                    alert.showAndWait();

                } catch (FileNotFoundException | DocumentException e) {
                    e.printStackTrace();

                }

            }


    public void logout(ActionEvent event) throws IOException, SQLException  {
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








