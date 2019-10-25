
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
				response.getWriter()
				.print("Successfully added " + request.getParameter("addMoney")
						+ " to your account : " + rs.getString("AccountNumber"));
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
