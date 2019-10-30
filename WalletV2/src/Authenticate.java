
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/authenticate")
public class Authenticate extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String userContact = request.getParameter("userCONTACT");
		String userPass = request.getParameter("userPass");

		Connection conn = (Connection) request.getServletContext().getAttribute("dbCon");
		if (conn != null) {
			try {

				String authQry = "select userCONTACT,userNAME from accountdetails where userCONTACT = ? AND userPASSWORD = ?";
				PreparedStatement pstmt = conn.prepareStatement(authQry);
				pstmt.setString(1, userContact);
				pstmt.setString(2,userPass);
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					String name = rs.getString("userNAME");
					request.getSession().setAttribute("userContact", rs.getString("userCONTACT"));;
					response.getWriter().print("Welcome " + name);
					request.getRequestDispatcher("home.jsp").include(request, response);

				} else {
					response.getWriter().print("Invalid creditionals...");
					request.getRequestDispatcher("index.jsp").include(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	}}



