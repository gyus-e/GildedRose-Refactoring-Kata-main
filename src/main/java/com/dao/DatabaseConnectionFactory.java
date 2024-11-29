package com.dao;

import com.sqliteDAOImplement.SQLiteConnection;

public class DatabaseConnectionFactory {

    public static DatabaseConnection getDatabaseConnection() {
        return new SQLiteConnection();
    }

}
