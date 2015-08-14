package com.e2.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import com.e2.domain.Book;
import com.e2.service.BookShelfService;
import com.e2.web.form.BookListForm;

public class ListBookAction extends ActionSupport {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		BookShelfService bookService = (BookShelfService) getWebApplicationContext()
				.getBean("bookShelfServiceImpl");

		BookListForm bookListForm = (BookListForm) form;

		List<Book> list = bookService.getBooks();

		bookListForm.setBooks(list);

		return mapping.findForward("success");

	}
}
