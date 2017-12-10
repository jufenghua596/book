package com.lm.knight.domain;

import java.io.Serializable;

public class Books implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long bookId;

    private String name;

    private Integer number;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", number=" + number + "]";
	}
    
    
    
}