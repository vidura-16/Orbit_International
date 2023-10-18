package com.example.international;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    public Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/orbit", "root", "");
        } catch (SQLException | ClassNotFoundException e){


        }
        return connection;
    }

}
