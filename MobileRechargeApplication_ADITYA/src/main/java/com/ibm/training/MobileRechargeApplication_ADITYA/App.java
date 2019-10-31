package com.ibm.training.MobileRechargeApplication_ADITYA;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.training.MobileRechargeApplication_ADITYA.service.AccountServiceImplementation;

public class App {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

		AccountServiceImplementation service = context.getBean("accService", AccountServiceImplementation.class);
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("------------------------------------------------------");
			System.out.println("\t\t\tMENU");
			System.out.println("------------------------------------------------------");
			System.out.println("\n1. Account Balance Enquiry \n2. Recharge Account \n3. Exit");
			try {

				System.out.print("\nEnter your operation : ");
				int option = sc.nextInt();
				switch (option) {

				case 1:
					int ch = 1;
					while (ch > 0) {
						System.out.print("\nEnter mobile number : ");
						String mobileNumber = sc.next();
						if (mobileNumber.length() == 10) {
							ch = 0;
							if (service.validateMobileNumber(mobileNumber)) {
								System.out.println(service.getAccountDetails(mobileNumber));
							} else
								System.out.println("ERROR: Given Account Id Does Not Exists");
						} else
							System.out.println("Mobile number should be of 10 digits");
					}
					break;

				case 2:
					int ch2 = 1;
					while (ch2 > 0) {
						System.out.print("\nEnter mobile number : ");
						String mobileNumber1 = sc.next();
						if (mobileNumber1.length() == 10) {
							ch2 = 0;
							System.out.print("\nEnter the amount : ");
							double amount = sc.nextDouble();
							if (service.validateMobileNumber(mobileNumber1)) {
								System.out.println("Your Account Recharged Successfully \nYour new Balance is : "
										+ service.rechargeAccount(mobileNumber1, amount));
							} else
								System.out.println("ERROR: Given Account Id Does Not Exists");
						} else
							System.out.println("Mobile number should be of 10 digits");
					}
					break;

				case 3:
					System.exit(0);
					break;

				default:
					System.out.println("Enter the correct operation...");
					break;

				}
			} catch (InputMismatchException ex) {
				System.out.println("Enter the correct input...");
			}
		}
	}
}
