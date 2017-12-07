package com.senla.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/bookshop?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


	// write your code here
        try {
           //Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("executed");
            LOGGER.info("connected to database" + URL + "executed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
