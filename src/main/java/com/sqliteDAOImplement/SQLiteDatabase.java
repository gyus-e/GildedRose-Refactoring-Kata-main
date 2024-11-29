package com.sqliteDAOImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteDatabase {
	
	protected Connection conn;
	
	protected SQLiteDatabase() {
		try {
			conn = new SQLiteConnection().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void executeQuery (String sqlQuery) {
		Statement st;
		try {
			st = conn.createStatement();
			st.execute(sqlQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected ResultSet getQueryResultSet (String sqlQuery) {
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement(sqlQuery);
			return pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
