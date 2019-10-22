package com.ibm.maven_wallet.service;

import java.util.ArrayList;

import com.ibm.maven_wallet.bean.Account;
import com.ibm.maven_wallet.bean.Transactions;
import com.ibm.maven_wallet.dao.DaoClass;

public class ServiceClass implements ServiceInterface {

	DaoClass dao = new DaoClass();

	public boolean createAccount(Account userAcc) {

		return dao.createAccount(userAcc);

	}

	public boolean fundsDeposit(long depositAccountNumber, long depositAmount) {
		return dao.fundsDeposit(depositAccountNumber, depositAmount);
	}

	public boolean fundsWithdraw(long withDrawAccountNumber, long withDrawAmount) {
		return dao.fundsWithdraw(withDrawAccountNumber, withDrawAmount);
	}

	public int showBalance(long showBalanceAccountNumber) {
		return dao.showBalance(showBalanceAccountNumber);

	}

	public boolean fundTransfer(long transferFromAccountNumber, long transferToAccountNumber, long transferFromAmount) {
		return dao.fundTransfer(transferFromAccountNumber, transferToAccountNumber, transferFromAmount);
	}

	public boolean validateAccountNumber(long depositAccountNumber) {
		if (depositAccountNumber != 0)
			return dao.validateAccountNumber(depositAccountNumber);
		return false;
	}

	public boolean checkMinBalance(long withDrawAmount, long withDrawAccountNumber) {
		if (withDrawAmount != 0)
			return dao.checkMinBalance(withDrawAmount, withDrawAccountNumber);
		return false;
	}

	public boolean alreadyExists(String userContact) {
		if (userContact != null)
			return dao.alreadyExists(userContact);
		return false;

	}

	public ArrayList<Transactions> transactionDetail(long accountTransactionDetail) {
		return dao.transactionDetail(accountTransactionDetail);
		
	}

	public void transactionCredit(long depositAccountNumber, long depositAmount) {
		dao.transactionCredit(depositAccountNumber, depositAmount);
		
	}

	public void transactionDebit(long withDrawAccountNumber, long withDrawAmount) {
		dao.transactionDebit(withDrawAccountNumber,withDrawAmount);
		
	}
}
