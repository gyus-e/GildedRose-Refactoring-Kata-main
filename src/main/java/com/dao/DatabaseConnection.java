package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DatabaseConnection {

    protected static Connection connection = null;
    protected static DatabaseConnection instance = null;

    public static DatabaseConnection getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = DatabaseConnectionFactory.getDatabaseConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
