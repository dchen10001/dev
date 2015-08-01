package com.e2.service;

import com.e2.vo.BookVO;

public interface BookShelfService {

	public  long insertBook(BookVO bookVO); 

	public  BookVO getBook(String title); 
}
