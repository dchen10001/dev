package com.e2.web.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

@SuppressWarnings("serial")
public class BookForm extends ActionForm {
	private long bookId; 
	
	private String bookName; 
	
	private String author; 
	
	
	public BookForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
	HttpServletRequest request) {
 
	    ActionErrors errors = new ActionErrors();
 
	    if( getBookName() == null || ("".equals(getBookName()))) {
	       errors.add("book.err.name",
              new ActionMessage("book.err.name.required"));
	    }
	    
	    if( getAuthor() == null || ("".equals(getAuthor()))) {
		   errors.add("book.author.err",
	           new ActionMessage("book.err.author.required"));
		}

	    return errors;
	}
 
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset properties
		bookName = "";
		author = "";
	}	
}
