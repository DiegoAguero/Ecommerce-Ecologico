/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
/**
 * @author Diego Aguero, David Vazquez, David Emiliano
 */
public class Connect {
    public Connect(){}
    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        try {
            // Properties props = new Properties();
            // props.load(new FileInputStream("./db.properties"));
            // String URL = props.getProperty("URL");
            // String DRIVER = props.getProperty("DRIVER");
            // String USER = props.getProperty("USER");
            // String PASSWORD = props.getProperty("PASSWORD");
            String URL = "jdbc:mysql://localhost/ecommerce_db?allowPublicKeyRetrieval=true&autoReconnect=true&useSSL=false&characterEncoding=UTF-8";
            String DRIVER = "com.mysql.cj.jdbc.Driver";
            String USER = "root";
            String PASSWORD = "1234";
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
