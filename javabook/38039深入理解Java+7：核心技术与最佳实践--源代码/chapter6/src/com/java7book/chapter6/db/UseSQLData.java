package com.java7book.chapter6.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class UseSQLData {
	
	public void useSQLData() throws SQLException {
		try (Connection connection = DriverManager
				.getConnection("jdbc:derby://localhost/java7book")) {
			Map<String,Class<?>> typeMap = new HashMap<String,Class<?>>();
			typeMap.put("java7book.Book", Book.class);
			try (Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM book")) {
				while (rs.next()) {
					System.out.println(rs.getObject(1, Book.class));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		UseSQLData usd = new UseSQLData();
		try {
			usd.useSQLData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
