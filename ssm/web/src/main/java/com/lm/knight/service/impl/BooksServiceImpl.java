package com.lm.knight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lm.knight.dao.BooksMapper;
import com.lm.knight.domain.Books;
import com.lm.knight.service.BooksService;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksMapper bookDao;

	@Override
	public Books selectByPrimaryKey(long bookId) {
		return bookDao.selectByPrimaryKey(bookId);
	}

}
