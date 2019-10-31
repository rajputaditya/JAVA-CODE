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

@WebServlet("/fundstransfer")
public class Fundstransfer extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		int flag=0;
		Connection conn = (Connection) request.getServletContext().getAttribute("dbCon");
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String transferFromQry = "select accountBalance from accountdetails where userCONTACT='"
					+ request.getSession().getAttribute("userContact") + "'";

			ResultSet rs1 = stmt.executeQuery(transferFromQry);
			if (rs1.next()) {

				if (rs1.getInt(1) >= Long.parseLong(request.getParameter("transferAmount"))) {
					long newtransferFromAmount = rs1.getInt(1) - Long.parseLong(request.getParameter("transferAmount"));
					
					String subQry = "update accountdetails set accountBalance=" + newtransferFromAmount
							+ " where userCONTACT='" + request.getSession().getAttribute("userContact") + "'";
					if(stmt.executeUpdate(subQry) > 0) {
						flag=1;
					}
					String transferToQry = "select accountBalance from accountdetails where userCONTACT='"
							+ request.getParameter("destMobile") + "'";
					ResultSet rs2 = stmt.executeQuery(transferToQry);

					if (rs2.next()) {

						long newtransferToAmount = rs2.getInt(1)
								+ Long.parseLong(request.getParameter("transferAmount"));
						String addQry = "update accountdetails set accountBalance=" + newtransferToAmount
								+ " where userCONTACT='" + request.getParameter("destMobile") + "'";

						if (stmt.executeUpdate(addQry) > 0 && flag==1) {
							response.getWriter().print("Successfully transffered the amount...");
							request.getRequestDispatcher("home.jsp").include(request, response);
						}

					}
				} else {
					response.getWriter().print("Not sufficient balance!!");
					request.getRequestDispatcher("fundsTransfer.jsp").include(request, response);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
