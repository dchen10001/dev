package com.e2.ws.service;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.e2.service.BookShelfService;
import com.e2.vo.BookVO;

public class SoapBookShelfClient {
	private final static String URL = "http://localhost:8080/SoapWS/services/bookShelfService?wsdl";

	public static void main(String args[]) throws Exception {
		SoapBookShelfService bookService = createSoapClient(SoapBookShelfService.class);		
		bookService.getBook("Foundation and Earth"); 
		//add book 
		BookVO bookVO = new BookVO();
		bookVO.setAuthor("Issac Asimov"); 
		bookVO.setBookName("Foundation and Earth"); 
		long result = bookService.insertBook(bookVO); 

		bookVO = new BookVO(); 
		bookVO.setAuthor("Issac Asimov"); 
		bookVO.setBookName("Foundation and Empire"); 
		result = bookService.insertBook(bookVO); 


		bookVO = new BookVO(); 
		bookVO.setAuthor("Arthur C Clarke"); 
		bookVO.setBookName("Rama Revealed"); 
		result = bookService.insertBook(bookVO); 

		//retrieve book 
		bookVO = bookService.getBook("Foundation and Earth"); 
		System.out.println("<--------------------------------------------->");
	}

	
	@SuppressWarnings("unchecked")
	public static <T> T createSoapClient(Class<T> cls) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		factory.setServiceClass(cls);
		factory.setAddress(URL);
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		T client = (T) factory.create();
		return client;
	}
}
