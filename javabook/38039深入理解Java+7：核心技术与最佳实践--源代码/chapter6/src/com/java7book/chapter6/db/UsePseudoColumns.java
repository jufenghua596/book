package com.java7book.chapter6.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class UsePseudoColumns {
	
	public void usePseudoColumns() throws SQLException {
		try (Connection connection = DriverManager
				.getConnection("jdbc:derby://localhost/java7book")) {
			DatabaseMetaData dbMetaData = connection.getMetaData();
			ResultSet rs = dbMetaData.getPseudoColumns(null, "SYS", "*", "*");
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int columnNum = rsMetaData.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnNum; i++) {
					System.out.println(rs.getObject(i));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		UsePseudoColumns upc = new UsePseudoColumns();
		try {
			upc.usePseudoColumns();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
