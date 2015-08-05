package com.e2.dao;

import com.e2.domain.Book;

public interface BookShelfServiceDao {
	public  long persisten(Book book); 
	public  Book getBookByTitle(String title);
	public Book getBookById(long bookId);
}
