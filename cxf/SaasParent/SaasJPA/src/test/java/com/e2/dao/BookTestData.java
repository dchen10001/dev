package com.e2.dao;

import com.e2.domain.Book;

public class BookTestData {
	public final static String[] authors = {"Issac Asimov", "Issac Asimov", "Arthur C Clarke"};
	public final static String[] titiles = {"Foundation and Earth", "Foundation and Empire", "Rama Revealed"};

	public static Book[] getBooks() {
		Book[] books = new Book[authors.length];
		for(int i = 0; i < books.length; i++) {
			books[i] = new Book();
			books[i].setAuthor(authors[i]); 
			books[i].setBookName(titiles[i]);
		}
		return books;
	}
}
