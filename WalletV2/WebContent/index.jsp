<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center><h1>Personal Wallet Web APP</h1><br><br>
	<table border="1px" cellpadding="20px">
	<form action="authenticate" method="post">
	<tr>
		<td>
		Mobile N : <input type=text placeholder="Enter your mobile number" name="userCONTACT" style="width:250px;height:50px" required><br><br>
		</td>
	</tr>
	
	<tr>
		<td>
		Password : <input type=password placeholder="Enter your password" name="userPass" style="width:250px;height:50px" required><br><br>
		</td>
	</tr>
	
	<tr>
		<td>
		<input type=reset value="RESET" style="margin-left:10px;width:150px;height:50px;background-color:red;color:white">
		<input type=submit value="LOGIN" style="width:150px;height:50px;background-color:green;color:white">
		
		</td>
	</tr>
	</form>
	</table>
	<p><a href="signup.html">Create Account</a></p>
	</center>
</body>
</html>