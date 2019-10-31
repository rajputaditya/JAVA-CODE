package com.ibm.wallet.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		Connection conn = (Connection) request.getServletContext().getAttribute("dbCon");

		try {
			Statement stmt = conn.createStatement();

			String showbalanceQry = "select accountBalance,userNAME,AccountNumber from accountdetails where userCONTACT='"
					+ request.getSession().getAttribute("userContact") + "'";
			ResultSet rs = stmt.executeQuery(showbalanceQry);
			if (rs.next()) {
				response.getWriter().println("Hello " + rs.getString("userNAME") + ", ");
				response.getWriter().println("current balance in your account " + rs.getString("AccountNumber") + " : "
						+ rs.getLong("accountBalance"));
				request.getRequestDispatcher("home.jsp").include(request, response);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
