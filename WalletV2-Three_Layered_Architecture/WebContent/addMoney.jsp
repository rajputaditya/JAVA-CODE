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
	<h1>Enter AMOUNT</h1><br>
	<form action="addMoneyService" method="post">
		<input type="number" placeholder="enter the AMOUNT here" name="addMoney" required><br>
		<input type="submit" value="DEPOSIT">
	</form>
</center>
</body>
</html>