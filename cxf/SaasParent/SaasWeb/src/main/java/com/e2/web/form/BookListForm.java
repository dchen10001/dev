package com.e2.web.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.e2.domain.Book;

@SuppressWarnings("serial")
public class BookListForm extends ActionForm {
	protected List<Book> books;

	public List<Book> getBooks() {
		if(books == null) {
			books = new ArrayList<Book>();
		}
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
