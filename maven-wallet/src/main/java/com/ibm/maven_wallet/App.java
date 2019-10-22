package com.ibm.maven_wallet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ibm.maven_wallet.bean.Account;
import com.ibm.maven_wallet.bean.Transactions;
import com.ibm.maven_wallet.service.ServiceClass;

public class App {
	public static void main(String[] args) {

		while (true) {

			ServiceClass service = new ServiceClass();
			Account userAcc = new Account();
			Scanner sc = new Scanner(System.in);
			System.out.println("------------------------------------------------------------------" + "\n\t\t\t\tMENU"
					+ "\n ------------------------------------------------------------------" + "\n1. CREATE ACCOUNT"
					+ "\n2. FUNDS DEPOSIT" + "\n3. FUNDS WITHDRAW" + "\n4. FUNDS TRANSFER" + "\n5. BALANCE"
					+ "\n6. PRINT TRANSACTIONS" + "\n7. EXIT");
			try {
				System.out.print("\nEnter your choice : ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:

					System.out.print("Enter Name : ");
					String userName = sc.nextLine();
					System.out.print("\nEnter Age : ");
					int userAge = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Contact Number : ");
					String userContact = sc.nextLine();
					if (userContact.length() < 10 || userContact.length() > 10)
						System.out.println("Enter a valid mobile number !");
					else {
						if (!(service.alreadyExists(userContact))) {
							System.out.println("Enter Address : ");
							String userAddress = sc.nextLine();
							System.out.println("Enter initial amount : ");
							double userAmount = sc.nextDouble();

							userAcc.setUserName(userName);
							userAcc.setUserAge(userAge);
							userAcc.setUserContact(userContact);
							userAcc.setUserAddress(userAddress);
							userAcc.setUserAmount(userAmount);

							if (service.createAccount(userAcc)) {
								System.out.println("Successfully created an account");
							}
							else
								System.out.println(
										"Their is some issue while creating the account, Please try back later.");
						}

						else
							System.out.println("Account already exists !");
					}

					break;

				case 2:
					System.out.print("Enter your account number : ");
					long depositAccountNumber = sc.nextLong();

					if (service.validateAccountNumber(depositAccountNumber)) {
						System.out.println("Enter the amount you want to add : ");
						long depositAmount = sc.nextLong();
						if (service.fundsDeposit(depositAccountNumber, depositAmount)) {
							service.transactionCredit(depositAccountNumber, depositAmount);
							System.out.println("Successfully added " + depositAmount + " to your account : "
									+ depositAccountNumber);
						} else
							System.out.println("Some issue is their, please try back later");
					} else
						System.out.println("Account Number is not valid, Please enter the correct account number.");
					break;

				case 3:
					System.out.print("Enter your account number : ");
					long withDrawAccountNumber = sc.nextLong();
					if (service.validateAccountNumber(withDrawAccountNumber)) {
						System.out.println("Enter the amount you want to withdraw : ");
						long withDrawAmount = sc.nextLong();
						if (service.checkMinBalance(withDrawAmount, withDrawAccountNumber)) {
							if (service.fundsWithdraw(withDrawAccountNumber, withDrawAmount)) {
								service.transactionDebit(withDrawAccountNumber, withDrawAmount);
								System.out.println("Successfully withdrawn " + withDrawAmount + "from your account : "
										+ withDrawAccountNumber);
							}
						} else
							System.out.println("Not sufficient balance in your account : " + withDrawAccountNumber);

					} else
						System.out.println("Account Number is not valid, Please enter the correct account number");
					break;

				case 4:
					System.out.println("Enter your account number : ");
					long transferFromAccountNumber = sc.nextLong();
					if (service.validateAccountNumber(transferFromAccountNumber)) {
						System.out.println("Enter the destination account number : ");
						long transferToAccountNumber = sc.nextLong();
						if (service.validateAccountNumber(transferToAccountNumber)) {
							System.out.println("Enter the amount you want to transfer : ");
							long transferFromAmount = sc.nextLong();
							if (service.checkMinBalance(transferFromAmount, transferFromAccountNumber)) {

								System.out.println("Successfully transffered " + transferFromAmount + " from "
										+ transferFromAccountNumber + " to account " + transferToAccountNumber);

								service.fundTransfer(transferFromAccountNumber, transferToAccountNumber,
										transferFromAmount);
								service.transactionDebit(transferFromAccountNumber, transferFromAmount);
								service.transactionCredit(transferToAccountNumber, transferFromAmount);
							} else
								System.out.println("Not sufficent balance in account : " + transferFromAccountNumber);
						} else
							System.out.println(
									"Destination account number is not valid, Enter a correct account number.");
					} else
						System.out.println("Invalid account number, Enter a correct account number.");

					break;

				case 5:
					System.out.print("Enter your account number : ");
					long showBalanceAccountNumber = sc.nextLong();
					if (service.validateAccountNumber(showBalanceAccountNumber))
						System.out.println("Current balance in account " + showBalanceAccountNumber + " : "
								+ service.showBalance(showBalanceAccountNumber));
					else
						System.out.println("Account Number is not valid, Please enter the correct account number");
					break;

				case 6:
					System.out.print("Enter your account number : ");
					long accountTransactionDetail = sc.nextLong();

					if (service.validateAccountNumber(accountTransactionDetail)) {
						ArrayList<Transactions> translist = service.transactionDetail(accountTransactionDetail);
						System.out
								.println("Transaction Details of account number :  " + accountTransactionDetail + "\n");
						System.out.println("------------------------------------------------------------------");
						System.out.println("ACCOUNT NUMBER \tCREDIT \tDEBIT \tDATE AND TIME \t\tBALANCE");
						System.out.println("------------------------------------------------------------------");
						for (Transactions tr : translist) {
							System.out.println(tr.getAccountNumber() + "\t" + tr.getCredit() + "\t" + tr.getDebit()
									+ "\t" + tr.getDate() + "\t" + tr.getAccountBalance());
						}
					} else
						System.out.println("Invalid account number, please enter the correct account number.");
					break;

				case 7:
					System.out.println(" ___________________________THANK YOU VISIT AGAIN ________________________");
					System.exit(0);
					break;

				default:
					System.out.println("Enter a correct input ...");
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter the correct input !!");
			}
		}
	}
}
