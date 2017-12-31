package com.senla.booksshop.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcMySqlUtil {

    private static final String DATABASE    = "bookshop";
    private static final String URL         = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
    private static final String USERNAME    = "root";
    private static final String PASSWORD    = "root";

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcMySqlUtil.class);

    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null){
            return connection;
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            LOGGER.info("open connection with database " + URL);
        } catch (SQLException e) {
            LOGGER.error("SQLException when you try to connect to" + URL, e);
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
                LOGGER.info("close connection with database " + URL );
            } catch (SQLException e) {
                LOGGER.error("SQLException when you try close connection with"  + URL, e);
                throw new RuntimeException(e);
            }
        }
    }
}
