package com.example.international;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =DriverManager.getConnection("jdbc:mysql://localhost/orbit", "root", "");
            System.out.println("Connection succeed");
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Connection failed");
        }
        return null;
    }
}
