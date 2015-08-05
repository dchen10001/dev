package com.e2.dao;

import java.util.List;

import com.e2.domain.Book;

public interface BookShelfServiceDao {
	public  long persisten(Book book); 
	public  Book getBookByTitle(String title);
	public Book getBookById(long bookId);
	public void removeBookById(long bookId);
	
	public List<Long> getBookIds();
}
