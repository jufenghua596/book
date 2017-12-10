package com.lm.knight.service;

import com.lm.knight.domain.Books;

public interface BooksService {

	Books selectByPrimaryKey(long bookId);

}
