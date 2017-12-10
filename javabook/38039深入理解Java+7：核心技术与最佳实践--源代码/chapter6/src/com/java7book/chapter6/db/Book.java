package com.java7book.chapter6.db;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Book implements SQLData {

	@Override
	public String getSQLTypeName() throws SQLException {
		return "java7book.Book";
	}

	@Override
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		System.out.println(typeName);
	}

	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		
	}

}
