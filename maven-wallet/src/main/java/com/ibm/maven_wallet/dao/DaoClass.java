package com.ibm.maven_wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.ibm.maven_wallet.bean.Account;
import com.ibm.maven_wallet.bean.Transactions;

public class DaoClass {

	Scanner sc = new Scanner(System.in);

	public String accountNumber = "10";

	public Connection dbConnection() {
		Connection dbCon = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccount", "root", "");
			if (dbCon != null) {
				return dbCon;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbCon;
	}

	public boolean createAccount(Account userAcc) {
		// TODO Auto-generated method stub
		accountNumber += userAcc.getUserContact();
		Connection dbCon = new DaoClass().dbConnection();
		try {
			Statement stmt = dbCon.createStatement();

			String insQry = "insert into accountdetails(userNAME, userAGE, userCONTACT, userADDRESS, AccountNumber, accountBalance) "
					+ "values('" + userAcc.getUserName() + "'," + userAcc.getUserAge() + ",'" + userAcc.getUserContact()
					+ "'," + "'" + userAcc.getUserAddress() + "','" + accountNumber + "'," + userAcc.getUserAmount()
					+ ")";

			// Execute the query
			if (stmt.executeUpdate(insQry) > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean fundsDeposit(long depositAccountNumber, long depositAmount) {
		Connection dbCon = new DaoClass().dbConnection();

		try {
			Statement stmt = dbCon.createStatement();

			String depQry = "select accountBalance from accountdetails where AccountNumber='" + depositAccountNumber
					+ "'";
			ResultSet rs = stmt.executeQuery(depQry);
			if (rs.next()) {
				long newAmount = rs.getInt(1) + depositAmount;
				String addQry = "update accountdetails set accountbalance=" + newAmount + " where AccountNumber='"
						+ depositAccountNumber + "'";
				if (stmt.executeUpdate(addQry) > 0)
					return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean fundsWithdraw(long withDrawAccountNumber, long withDrawAmount) {

		Connection dbCon = new DaoClass().dbConnection();

		try {
			Statement stmt = dbCon.createStatement();

			String withDrawQry = "select accountBalance from accountdetails where AccountNumber='"
					+ withDrawAccountNumber + "'";
			ResultSet rs = stmt.executeQuery(withDrawQry);
			if (rs.next()) {
				long newAmount = rs.getInt(1) - withDrawAmount;
				String subQry = "update accountdetails set accountbalance=" + newAmount + " where AccountNumber='"
						+ withDrawAccountNumber + "'";
				if (stmt.executeUpdate(subQry) > 0)
					return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public int showBalance(long showBalanceAccountNumber) {
		Connection dbCon = new DaoClass().dbConnection();

		try {
			Statement stmt = dbCon.createStatement();

			String showbalanceQry = "select accountBalance from accountdetails where AccountNumber='"
					+ showBalanceAccountNumber + "'";
			ResultSet rs = stmt.executeQuery(showbalanceQry);
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public boolean fundTransfer(long transferFromAccountNumber, long transferToAccountNumber, long transferFromAmount) {
		int flag = 0;
		Connection dbCon = new DaoClass().dbConnection();
		try {
			Statement stmt = dbCon.createStatement();

			String transferFromQry = "select accountBalance from accountdetails where AccountNumber='"
					+ transferFromAccountNumber + "'";

			ResultSet rs1 = stmt.executeQuery(transferFromQry);
			if (rs1.next()) {

				if (rs1.getInt(1) >= transferFromAmount) {
					long newtransferFromAmount = rs1.getInt(1) - transferFromAmount;
					String subQry = "update accountdetails set accountbalance=" + newtransferFromAmount
							+ " where AccountNumber='" + transferFromAccountNumber + "'";
					if (stmt.executeUpdate(subQry) > 0)
						flag = 1;

					String transferToQry = "select accountBalance from accountdetails where AccountNumber='"
							+ transferToAccountNumber + "'";
					ResultSet rs2 = stmt.executeQuery(transferToQry);

					if (rs2.next()) {

						long newtransferToAmount = rs2.getInt(1) + transferFromAmount;
						String addQry = "update accountdetails set accountbalance=" + newtransferToAmount
								+ " where AccountNumber='" + transferToAccountNumber + "'";

						if (stmt.executeUpdate(addQry) > 0 && flag == 1)
							return true;
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public boolean validateAccountNumber(long depositAccountNumber) {
		Connection dbCon = new DaoClass().dbConnection();
		try {
			Statement stmt = dbCon.createStatement();
			String validateAccountQry = "select userNAME from accountdetails where AccountNumber = "
					+ depositAccountNumber;
			ResultSet rs = stmt.executeQuery(validateAccountQry);
			if (rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean checkMinBalance(long withDrawAmount, long withDrawAccountNumber) {
		Connection dbCon = new DaoClass().dbConnection();
		try {
			Statement stmt = dbCon.createStatement();

			String checkBalQry = "select accountBalance from accountdetails where AccountNumber='"
					+ withDrawAccountNumber + "'";

			ResultSet rs = stmt.executeQuery(checkBalQry);
			if (rs.next())
				if (rs.getInt(1) >= withDrawAmount)
					return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean alreadyExists(String userContact) {
		Connection dbCon = new DaoClass().dbConnection();
		try {
			Statement stmt = dbCon.createStatement();
			String validateAccountQry = "select userNAME from accountdetails where userCONTACT = " + userContact;
			ResultSet rs = stmt.executeQuery(validateAccountQry);
			if (rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public void transactionCredit(long depositAccountNumber, long depositAmount) {

		Connection dbCon = new DaoClass().dbConnection();
		long trBal = 0;
		try {
			Statement stmt = dbCon.createStatement();
			String fetchBalQry = "select accountBalance from accountDetails where AccountNumber="
					+ depositAccountNumber;
			ResultSet rs = stmt.executeQuery(fetchBalQry);
			if (rs.next())
				trBal = rs.getLong(1);

			String creditQry = "insert into transactiondetails(accountNumber, credit, accountBalance) values("
					+ depositAccountNumber + "," + depositAmount + "," + trBal + ")";
			stmt.executeUpdate(creditQry);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void transactionDebit(long withDrawAccountNumber, long withDrawAmount) {
		
		Connection dbCon = new DaoClass().dbConnection();
		long trBal = 0;
		try {
			Statement stmt = dbCon.createStatement();
			String fetchBalQry = "select accountBalance from accountDetails where AccountNumber="
					+ withDrawAccountNumber;
			ResultSet rs = stmt.executeQuery(fetchBalQry);
			if (rs.next())
				trBal = rs.getLong(1);

			String debitQry = "insert into transactiondetails(accountNumber, debit, accountBalance) values("
					+ withDrawAccountNumber + "," + withDrawAmount + "," + trBal + ")";
			stmt.executeUpdate(debitQry);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Transactions> transactionDetail(long accountTransactionDetail) {
		Connection dbCon = new DaoClass().dbConnection();
		ArrayList<Transactions> transactionList = new ArrayList<Transactions>();
		Transactions transDetail=null;
		try {
			Statement stmt = dbCon.createStatement();
			String fetchTrcQry = "select * from transactionDetails where AccountNumber="
					+ accountTransactionDetail;
			ResultSet rs = stmt.executeQuery(fetchTrcQry);
			while (rs.next()) {
				
				transDetail=new Transactions();
				transDetail.setAccountNumber(rs.getLong("accountNumber"));
				transDetail.setCredit(rs.getLong("credit"));
				transDetail.setDebit(rs.getLong("debit"));
				transDetail.setDate(rs.getString("date"));
				transDetail.setAccountBalance(rs.getLong("accountBalance"));
				transactionList.add(transDetail);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactionList;
	}
}
