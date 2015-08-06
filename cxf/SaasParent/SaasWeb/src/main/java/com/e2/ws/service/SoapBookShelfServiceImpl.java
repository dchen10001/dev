package com.e2.ws.service;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
		return bookService.insertBook(bookVO);
	}

	@Override
	public BookVO getBook(String title) {
		return bookService.getBookByTitle(title);
	}

}
