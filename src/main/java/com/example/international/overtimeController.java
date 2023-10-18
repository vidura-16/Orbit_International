package com.example.international;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class overtimeController {
        @FXML
        private Label time;

        @FXML
        private Label date;

        @FXML
        private Label txtTime;

        @FXML
        private Label txtDate;

        @FXML
        private Label txtTime1;

        @FXML
        private Label txtDate1;

        @FXML
        private Label timeDifference;

        @FXML
        private TextField fieldID;

        @FXML
        private Button savetimeBtn;

        private int minute;
        private int hour;
        private int second;
        int Date;
        int month;
        int year;
        private volatile boolean stop = false;

    public overtimeController() throws ParseException {
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

    private void timeNow(){
            Thread thread=new Thread(() ->{
                SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss a");
                Calendar cal = Calendar.getInstance();
                while (!stop){
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    final String timenow= sdf.format(new Date());
                    Platform.runLater(() ->{
                        time.setText(timenow);
                        Date=cal.get(Calendar.DATE);
                        month=cal.get(Calendar.MONTH);
                        year=cal.get(Calendar.YEAR);
                        date.setText(Date+" / "+month+" / "+year);
                    });
                }
            });
            thread.start();
        }

    public void logIn(ActionEvent event) {
        LocalTime currentTime = LocalTime.now();
        LocalDate date = LocalDate.now();
        txtTime.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        txtDate.setText(String.valueOf(date));
        Connect();

    }

    @FXML
    void logOut(ActionEvent event) throws SQLException {
        LocalTime currentTime = LocalTime.now();
        LocalDate date = LocalDate.now();
        txtTime1.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        txtDate1.setText(String.valueOf(date));

        String StartTime = txtTime.getText();
        String StartDate = txtDate.getText();
        String endTime = txtTime1.getText();
        String endDate = txtDate1.getText();

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(StartTime);
            d2 = format.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        System.out.println("Time in seconds: " + diffSeconds + " seconds.");
        System.out.println("Time in minutes: " + diffMinutes + " minutes.");
        System.out.println("Time in hours: " + diffHours + " hours.");
        if(diffSeconds > 8)
        {
            timeDifference.setText(String.valueOf(diffSeconds - 8));
        }
        else
        {
            timeDifference.setText(null);
        }

        String overTime = timeDifference.getText();
        Connect();

        String id = fieldID.getText();
        ResultSet rs = c.createStatement().executeQuery("select endDate from employee where EmpID = '"+id+"'");
        if(rs.next()) {

        }

        try {
            pst = c.prepareStatement("insert into overtime(EmpID,startDate, startTime, endDate, endTime, overTime)values (?,?,?,?,?,?)");
            pst.setString(1, id);
            pst.setString(2, StartDate);
            pst.setString(3, StartTime);
            pst.setString(4, endDate);
            pst.setString(5, endTime);
            pst.setString(6, overTime);

            int status = pst.executeUpdate();

            if (status == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Time Added Successfully");
                alert.showAndWait();

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
        public void initialize() {
            timeNow();
        }
    }
