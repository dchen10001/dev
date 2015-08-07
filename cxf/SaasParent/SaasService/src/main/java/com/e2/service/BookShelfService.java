package com.e2.service;

import com.e2.domain.Book;

public interface BookShelfService {

	public  long insertBook(Book book); 

	public  Book getBookByTitle(String title); 

	public  Book getBookById(long bookId); 
	
	public void updateBook(long bookId, String auther, String title);
	
	public void removeBook(long bookId);
}
