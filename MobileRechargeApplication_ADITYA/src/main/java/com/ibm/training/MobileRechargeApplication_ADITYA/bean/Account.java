package com.ibm.training.MobileRechargeApplication_ADITYA.bean;

public class Account {
	
	private String accountType;
	private String customerName;
	private double accountBalance;
	
	public Account() {
		
	}
	
	public Account(String accountType, String customerName, double accountBalance) {
		this.customerName = customerName;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public String toString() {
		return "Your Current Balance is Rs. "+this.getAccountBalance();
	}

}
