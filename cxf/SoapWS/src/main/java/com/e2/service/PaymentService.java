package com.e2.service;

public interface PaymentService {
	
	public double deposit(String accountId, double amount) throws Exception;
	
	public double withdraw(String accountId, double amount) throws Exception;
	
	public double checkBlance(String accountId) throws Exception;	
}
