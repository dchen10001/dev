package com.e2.service;

import com.e2.vo.BookVO;

public interface BookShelfService {

	public  long insertBook(BookVO bookVO); 

	public  BookVO getBookByTitle(String title); 

	public  BookVO getBookById(long bookId); 
	
	public void updateBook(long bookId, String auther, String title);
	
	public void removeBook(long bookId);
}
