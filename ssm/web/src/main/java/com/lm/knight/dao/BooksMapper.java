package com.lm.knight.dao;

import com.lm.knight.domain.Books;

public interface BooksMapper {
    int deleteByPrimaryKey(Long bookId);

    int insert(Books record);

    int insertSelective(Books record);

    Books selectByPrimaryKey(Long bookId);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);
    

}