package com.e2.ws.service;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.e2.service.PaymentService;

@Service("soapPaymentServiceImpl")
@WebService(endpointInterface = "com.e2.ws.service.SoapPaymentService", targetNamespace = "com.e2.ws.service", name = "payment")
public class SoapPaymentServiceImpl implements SoapPaymentService {

	//@Resource(name="paymentServiceImpl")
	
	@Autowired
	@Qualifier("paymentServiceImpl")
	private PaymentService paymentService;
	
	@Override
	public double deposit(String accountId, double amount) throws Exception {
		return paymentService.deposit(accountId, amount);
	}

	@Override
	public double withdraw(String accountId, double amount) throws Exception {
		return paymentService.withdraw(accountId, amount);
	}

	@Override
	public double checkBlance(String accountId) throws Exception {
		return paymentService.checkBlance(accountId);
	}

}
