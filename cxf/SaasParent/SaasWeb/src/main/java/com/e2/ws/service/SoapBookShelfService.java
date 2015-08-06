package com.e2.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.e2.vo.BookVO;

@WebService(targetNamespace = "com.e2.ws.service.bookShelf", name = "bookShelf")
@SOAPBinding(style = Style.DOCUMENT)
public interface SoapBookShelfService {
	@WebMethod(operationName = "insertBook") 
	public  long insertBook(@WebParam(name = "bookVO", mode = Mode.IN)BookVO bookVO); 
	
	@WebMethod(operationName = "getBook") 
	public  BookVO getBook(@WebParam(name = "title", mode = Mode.IN)String title); 
}
