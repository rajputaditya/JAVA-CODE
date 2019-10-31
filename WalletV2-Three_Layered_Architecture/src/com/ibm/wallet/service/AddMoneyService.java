package com.ibm.wallet.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wallet.bean.Accounts;

@WebServlet("/addMoneyService")
public class AddMoneyService extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		request.getRequestDispatcher("addMoney").include(request, response);
	}

}
