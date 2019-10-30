<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Wallet</title>
</head>
<body>
<center>
		<h1>Create Account</h1>
		<table border="1px" cellpadding="10px">
			<form action="createAccount" method="post">
			<tr>
				<td>
					Name : <input type="text" name="userNAME" placeholder="enter your NAME" style="width:250px;height:50px;margin-left:10px" required><br>
				</td>
			</tr>
			<tr>
				<td>
					Password : <input type="password" name="userPASS" placeholder="enter your PASSWORD" style="width:250px;height:50px" required><br>
				</td>
			</tr>
			<tr>
				<td>
					Age : <input type="number" name="userAGE" placeholder="enter your Age" style="width:250px;height:50px;margin-left:20px" required><br>
				</td>
			</tr>
			<tr>
				<td>
					Contact : <input type="number" name="userCONTACT" placeholder="enter your MOBILE NUMBER" style="width:250px;height:50px" required><br>
				</td>
			</tr>
			<tr>
				<td>
					Address : <input type="text" name="userADDRESS" placeholder="enter your ADDRESS" style="width:250px;height:50px" required><br>
				</td>
			</tr>
			<tr>
				<td>
					Amount : <input type="number" name="userAMOUNT" placeholder="enter the initial AMOUNT" style="width:250px;height:50px" required><br>
				</td>
			</tr>
			<tr>
				<td>
					
					<input type=submit value="Create Account" style="width:150px;height:50px;background-color:green;color:white;margin-left:80px">
				</td>
			</tr>
		</form>
		</table>
		
		</center>
</body>
</html>