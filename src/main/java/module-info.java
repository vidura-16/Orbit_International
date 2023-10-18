module com.example.international {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires java.sql;
    requires mail;
    requires itextpdf;
    requires jasperreports;

    requires javafx.graphics;
    requires mysql.connector.java;
    requires java.desktop;

    opens com.example.international to javafx.fxml;
    exports com.example.international;
}