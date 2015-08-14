package com.e2.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import com.e2.domain.Book;
import com.e2.service.BookShelfService;
import com.e2.web.form.BookForm;

public class AddBookAction extends ActionSupport {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		BookShelfService bookService = (BookShelfService) getWebApplicationContext()
				.getBean("bookShelfServiceImpl");

		BookForm bookForm = (BookForm) form;
		Book book = new Book();
		book.setAuthor(bookForm.getAuthor());
		book.setBookName(bookForm.getBookName());
		// save it
		bookService.insertBook(book);

		return mapping.findForward("success");

	}
}
