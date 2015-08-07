package com.e2.ws.service;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.e2.domain.Book;
import com.e2.service.BookShelfService;
import com.e2.vo.BookVO;


@Service("soapBookShelfServiceImpl")
@WebService(endpointInterface = "com.e2.ws.service.SoapBookShelfService", serviceName="bookShelfService") 
public class SoapBookShelfServiceImpl implements SoapBookShelfService {
	
	@Autowired
	@Qualifier("bookShelfServiceImpl")	
	private BookShelfService bookService;
	
	@Override
	public long insertBook(BookVO bookVO) {
		Book book = new Book(bookVO.getBookName(), bookVO.getAuthor());
		return bookService.insertBook(book);
	}

	@Override
	public BookVO getBook(String title) {
		Book book = bookService.getBookByTitle(title);
		
		BookVO bookVO = null;
		if(book != null) {
			bookVO = new BookVO();
			bookVO.setBookName(book.getBookName());
			bookVO.setAuthor(book.getAuthor());
			bookVO.setBookId(book.getBookId());
		}
		return bookVO;
	}

}
