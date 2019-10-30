
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = { "/printStatement" })
public class PrintStatement extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		Connection conn = (Connection) request.getServletContext().getAttribute("dbCon");
		String fetchQry = "select * from transactiondetails where userCONTACT = ?";
		try {
			Transactions trans = null;
			java.sql.PreparedStatement pstmt = conn.prepareStatement(fetchQry);
			pstmt.setString(1, (String) request.getSession().getAttribute("userContact"));
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				trans = new Transactions();
				trans.setAccountNumber(rs.getLong("accountNumber"));
				trans.setCredit(rs.getInt("credit"));
				trans.setDebit(rs.getInt("debit"));
				trans.setAccountBalance(rs.getInt("accountBalance"));
				trans.setDate(rs.getString("date"));
				response.getWriter().println(trans.getAccountNumber() + "\t" + trans.getCredit() + "\t"
						+ trans.getDebit() + "\t" + trans.getAccountBalance() + "\t" + trans.getDate() + "<br>");
			}
			request.getRequestDispatcher("home.jsp").include(request, response);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
