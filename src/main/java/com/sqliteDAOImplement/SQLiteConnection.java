package com.sqliteDAOImplement;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.dao.DatabaseConnection;

public final class SQLiteConnection extends DatabaseConnection {
    public SQLiteConnection() {
        String url = "jdbc:sqlite:src/main/database/gildedRose.sqlite";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
