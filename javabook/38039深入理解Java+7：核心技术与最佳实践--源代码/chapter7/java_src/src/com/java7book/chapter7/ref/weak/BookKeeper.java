package com.java7book.chapter7.ref.weak;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BookKeeper {
	private Map<Book, Set<User>> books = new HashMap<>();
	
	public void borrowBook(Book book, User user) {
		Set<User> users = null;
		if (books.containsKey(book)) {
			users = books.get(book);
		}
		else {
			users = new HashSet<User>();
			books.put(book, users);
		}
		users.add(user);
	}
	
	public void returnBook(Book book, User user) {
		if (books.containsKey(book)) {
			Set<User> users = books.get(book);
			users.remove(user);
		}
	}
}
