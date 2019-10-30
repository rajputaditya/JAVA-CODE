
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

@WebServlet("/withdrawMoney")
public class WithdrawMoney extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		Connection conn = (Connection) request.getServletContext().getAttribute("dbCon");
		try {
			Statement stmt = conn.createStatement();

			String withDrawQry = "select accountBalance,AccountNumber from accountdetails where userCONTACT='"
					+ request.getSession().getAttribute("userContact") + "'";
			ResultSet rs = stmt.executeQuery(withDrawQry);
			if (rs.next()) {
				long newAmount = rs.getInt(1) - Long.parseLong(request.getParameter("withDrawMoney"));
				String subQry = "update accountdetails set accountbalance=" + newAmount + " where userCONTACT='"
						+ request.getSession().getAttribute("userContact") + "'";

				String debitQry = "insert into transactiondetails(accountNumber, debit, accountBalance,userCONTACT) values("
						+ rs.getString(2) + "," + Long.parseLong(request.getParameter("withDrawMoney")) + "," + newAmount
						+ "," + request.getSession().getAttribute("userContact") + ")";
				stmt.executeUpdate(debitQry);
				
				if (stmt.executeUpdate(subQry) > 0) {
					response.getWriter().print("Successfully withdrawn");
					request.getRequestDispatcher("home.jsp").include(request, response);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
