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

@WebServlet("/addMoney")
public class AddMoney extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		int flag = 0;

		Connection conn = (Connection) request.getServletContext().getAttribute("dbCon");
		try {
			Statement stmt = conn.createStatement();

			String depQry = "select accountBalance,AccountNumber from accountdetails where userCONTACT='"
					+ request.getSession().getAttribute("userContact") + "'";
			ResultSet rs = stmt.executeQuery(depQry);
			if (rs.next()) {
				long newAmount = rs.getInt(1) + Long.parseLong(request.getParameter("addMoney"));
				String addQry = "update accountdetails set accountbalance=" + newAmount + " where userCONTACT='"
						+ request.getSession().getAttribute("userContact") + "'";

				response.getWriter().print("Successfully added ");
				String creditQry = "insert into transactiondetails(accountNumber, credit, accountBalance,userCONTACT) values("
						+ rs.getString(2) + "," + Long.parseLong(request.getParameter("addMoney")) + "," + newAmount + ","
						+ request.getSession().getAttribute("userContact") + ")";

				stmt.executeUpdate(creditQry);
				if (stmt.executeUpdate(addQry) > 0) {

					request.getRequestDispatcher("home.jsp").include(request, response);

				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
