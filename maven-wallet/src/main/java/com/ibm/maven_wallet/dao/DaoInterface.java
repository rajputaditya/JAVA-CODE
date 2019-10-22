package com.ibm.maven_wallet.dao;

import java.util.ArrayList;

import com.ibm.maven_wallet.bean.Account;
import com.ibm.maven_wallet.bean.Transactions;

public interface DaoInterface {
	
	public boolean validateAccountNumber(long depositAccountNumber);
	public boolean checkMinBalance(long withDrawAmount, long withDrawAccountNumber);
	public boolean alreadyExists(String userContact);
	public void transactionCredit(long depositAccountNumber, long depositAmount);
	public void transactionDebit(long withDrawAccountNumber, long withDrawAmount);
	public ArrayList<Transactions> transactionDetail(long accountTransactionDetail);
	public boolean createAccount(Account userAcc);
	public boolean fundsDeposit(long depositAccountNumber, long depositAmount);
	public boolean fundsWithdraw(long withDrawAccountNumber, long withDrawAmount);
	public int showBalance(long showBalanceAccountNumber);
	public void fundTransfer(long transferFromAccountNumber, long transferToAccountNumber, long transferFromAmount);
}
