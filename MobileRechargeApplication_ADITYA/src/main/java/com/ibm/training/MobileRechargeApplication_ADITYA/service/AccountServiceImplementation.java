package com.ibm.training.MobileRechargeApplication_ADITYA.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.MobileRechargeApplication_ADITYA.bean.Account;
import com.ibm.training.MobileRechargeApplication_ADITYA.dao.AccountDaoImplementation;

@Service("accService")
public class AccountServiceImplementation implements AccountService {
	
	@Autowired
	AccountDaoImplementation dao;

	public Account getAccountDetails(String mobileNo) {
		
		return dao.getAccountDetails(mobileNo);
	}

	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		return dao.rechargeAccount(mobileNo, rechargeAmount);
	}


	public boolean validateMobileNumber(String mobileNumber) {
		if(mobileNumber.length()!=0)
			return dao.validateMobileNumber(mobileNumber);
		return false;
	}

}
