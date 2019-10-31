package com.ibm.training.MobileRechargeApplication_ADITYA.service;

import com.ibm.training.MobileRechargeApplication_ADITYA.bean.Account;

public interface AccountService {
	
	Account getAccountDetails(String mobileNo);
	int rechargeAccount(String mobileNo, double rechargeAmount);

}
