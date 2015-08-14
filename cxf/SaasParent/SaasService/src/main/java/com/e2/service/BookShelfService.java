package com.e2.service;

import java.util.List;

import com.e2.domain.Book;

public interface BookShelfService {

	public  long insertBook(Book book); 

	public  Book getBookByTitle(String title); 

	public  Book getBookById(long bookId); 
	
	public void updateBook(long bookId, String auther, String title);
	
	public void removeBook(long bookId);
	
	public List<Book> getBooks();
}
