package com.ibm.maven_wallet.service;

import java.util.ArrayList;

import com.ibm.maven_wallet.bean.Account;
import com.ibm.maven_wallet.bean.Transactions;

public interface ServiceInterface {
	
	public boolean validateAccountNumber(long depositAccountNumber);
	public boolean alreadyExists(String userContact);
	public void transactionCredit(long depositAccountNumber, long depositAmount);
	public void transactionDebit(long withDrawAccountNumber, long withDrawAmount);
	public ArrayList<Transactions> transactionDetail(long accountTransactionDetail);
	public boolean checkMinBalance(long withDrawAmount, long withDrawAccountNumber);
	public boolean createAccount(Account userAcc);
	public boolean fundsDeposit(long depositAccountNumber, long depositAmount);
	public boolean fundsWithdraw(long withDrawAccountNumber, long withDrawAmount);
	public int showBalance(long showBalanceAccountNumber);
	public boolean fundTransfer(long transferFromAccountNumber, long transferToAccountNumber, long transferFromAmount);

}
