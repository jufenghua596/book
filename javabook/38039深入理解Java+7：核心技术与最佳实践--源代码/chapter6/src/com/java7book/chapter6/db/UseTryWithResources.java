package com.java7book.chapter6.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UseTryWithResources {

	public void dbOperation() throws SQLException {
		try (Connection connection = DriverManager
				.getConnection("jdbc:derby://localhost/java7book");
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM book")) {
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		}
	}

	public static void main(String[] args) {
		UseTryWithResources utwr = new UseTryWithResources();
		try {
			utwr.dbOperation();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
