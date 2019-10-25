
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

@WebServlet("/createAccount")
public class CreateAccount extends HttpServlet {
	String accountNumber = "10";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String userName = request.getParameter("userNAME");
		int userAge = Integer.parseInt(request.getParameter("userAGE"));
		String userContact = request.getParameter("userCONTACT");
		String userAddress = request.getParameter("userADDRESS");
		String userPass = request.getParameter("userPASS");
		long userAmount = Long.parseLong(request.getParameter("userAMOUNT"));
		
		

		accountNumber += userContact;

		Connection conn = (Connection) request.getServletContext().getAttribute("dbCon");
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String insQry = "insert into accountdetails(userNAME, userAGE, userCONTACT, userADDRESS, AccountNumber, accountBalance, userPASSWORD) "
						+ "values('" + userName + "'," + userAge + ",'" + userContact
						+ "'," + "'" + userAddress + "','" + accountNumber + "'," + userAmount
						+",'"+userPass+ "')";
				
				if(stmt.executeUpdate(insQry)>0) {
					response.getWriter().print("Successfully created a new account...");
					request.getRequestDispatcher("index.jsp").include(request, response);
				}
				else
					response.getWriter().print("Some issue while creating an account, please try back later...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else
			response.getWriter().print("Not Successfully connected...");

	}
}
