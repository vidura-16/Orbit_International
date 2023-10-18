package com.example.international;


import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection databaseLink;

    public static Connection getConnection(){
        String databaseName = "orbit";
        String databaseUser = "root";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }

}
