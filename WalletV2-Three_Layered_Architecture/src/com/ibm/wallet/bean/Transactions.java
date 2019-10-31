package com.ibm.wallet.bean;

public class Transactions {
	private long accountNumber;
	private long credit;
	private long debit;
	private String date;
	private long accountBalance;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long l) {
		this.accountNumber = l;
	}

	public long getCredit() {
		return credit;
	}

	public void setCredit(long credit) {
		this.credit = credit;
	}

	public long getDebit() {
		return debit;
	}

	public void setDebit(long debit) {
		this.debit = debit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}

}
