package com.e2.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="BookList")
public class BookList {
	private List<BookVO> bookList;
	
	public BookList() {
		
	}

	public List<BookVO> getBookList() {
		if(bookList == null){ 
			bookList = new ArrayList<BookVO>(); 
		}
		return bookList;
	}

	public void setBookList(List<BookVO> bookList) {
		this.bookList = bookList;
	}
}
