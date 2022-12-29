package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String dbURL = "jdbc:mysql://localhost:3306/mydbtest";
    private final static String dbUserName = "root";
    private final static String dbPassword = "root";
    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}