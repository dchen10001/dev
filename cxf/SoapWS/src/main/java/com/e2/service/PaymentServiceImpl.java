package com.e2.service;

import org.springframework.stereotype.Service;

@Service("paymentServiceImpl")
public class PaymentServiceImpl implements PaymentService {

	@Override
	public double deposit(String accountId, double amount) throws Exception {
		return 0;
	}

	@Override
	public double withdraw(String accountId, double amount) throws Exception {
		return 0;
	}

	@Override
	public double checkBlance(String accountId) throws Exception {
		return 0;
	}
}
