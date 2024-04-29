/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.*;
import java.sql.*;
import java.util.*;
/**
 * @author Diego Aguero, David Vazquez, David Emiliano
 */
public class Connect {
    public Connect(){}
    private static Properties props = new Properties();
    static{
        try (InputStream inputStream = Connect.class.getClassLoader().getResourceAsStream("./config/db.properties")) {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        try {
            String URL = props.getProperty("URL");
            String DRIVER = props.getProperty("DRIVER");
            String USER = props.getProperty("USER");
            String PASSWORD = props.getProperty("PASSWORD");
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
