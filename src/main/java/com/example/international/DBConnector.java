package com.example.international;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    public static Connection getConnect() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/orbit","root","");

        return connection;
    }
}
