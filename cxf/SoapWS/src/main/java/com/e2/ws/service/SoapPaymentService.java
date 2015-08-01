package com.e2.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;

import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(targetNamespace = "com.e2.ws.service", name = "payment")
@SOAPBinding(style = Style.DOCUMENT)
public interface SoapPaymentService {
	
    @WebMethod(operationName = "deposit")
	public double deposit(@WebParam(name = "accountId", mode = Mode.IN) String accountId, @WebParam(name = "amount", mode = Mode.IN) double amount) throws Exception;
	
    @WebMethod(operationName = "withdraw")
	public double withdraw(@WebParam(name = "accountId", mode = Mode.IN) String accountId, @WebParam(name = "amount", mode = Mode.IN) double amount) throws Exception;
	
    @WebMethod(operationName = "checkBlance")
	public double checkBlance(@WebParam(name = "accountId", mode = Mode.IN) String accountId) throws Exception;	
}
