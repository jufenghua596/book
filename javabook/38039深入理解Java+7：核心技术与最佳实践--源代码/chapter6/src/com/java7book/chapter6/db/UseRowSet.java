package com.java7book.chapter6.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class UseRowSet {

	public void useRowSet() throws SQLException {
		RowSetFactory rsFactory = RowSetProvider.newFactory();
		try (JdbcRowSet jrs = rsFactory.createJdbcRowSet()) {
			jrs.setUrl("jdbc:derby://localhost/java7book");
			jrs.setCommand("SELECT * FROM book");
			jrs.execute();
			jrs.absolute(1);
			jrs.updateString("name", "New book");
			jrs.updateRow();
		}
	}
	
	public static void main(String[] args) {
		UseRowSet urs = new UseRowSet();
		try {
			urs.useRowSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
