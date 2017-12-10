package com.lm.knight.service;

import java.util.List;

import com.lm.knight.domain.Book;
import com.lm.knight.domain.Category;

public interface BookService {
    
    List<Category> getAllCategories();
    Category getCategory(int id);
    List<Book> getAllBooks();
    Book save(Book book);
    Book update(Book book);
    Book get(long id);
    long getNextId();

}
