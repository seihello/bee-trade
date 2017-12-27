package com.momoiropuchoman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DB {

	public static final String DB_NAME = "BeeTrade.db";

	protected Connection getConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}

	void close(Connection connection, PreparedStatement preparedStatement) {
		try {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			if(connection != null) {
				connection.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}