package com.ibm.wallet.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wallet.bean.Accounts;


@WebServlet("/createAccountService")
public class CreateAccountService extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Accounts userAcc = new Accounts();
		
		userAcc.setUserName(request.getParameter("userNAME"));
		userAcc.setUserAge(Integer.parseInt(request.getParameter("userAGE")));
		userAcc.setUserAddress(request.getParameter("userADDRESS"));
		userAcc.setUserContact(request.getParameter("userCONTACT"));
		userAcc.setUserAmount(Integer.parseInt(request.getParameter("userAMOUNT")));
		userAcc.setUserPassword(request.getParameter("userPASS"));
		
		request.setAttribute("accountDetails", userAcc);
		request.getRequestDispatcher("CreateAccount").include(request, response);
	}

}
