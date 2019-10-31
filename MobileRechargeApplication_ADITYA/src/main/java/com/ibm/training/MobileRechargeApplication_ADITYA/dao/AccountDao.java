package com.ibm.training.MobileRechargeApplication_ADITYA.dao;

import com.ibm.training.MobileRechargeApplication_ADITYA.bean.Account;

public interface AccountDao {
	
	Account getAccountDetails(String mobileNo);
	int rechargeAccount(String mobileNo, double rechargeAmount);

}
