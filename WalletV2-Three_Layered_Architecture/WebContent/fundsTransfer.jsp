<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

	<h1>MOBILE NUMBER YOU WANT TO TRANSFER</h1>
	<form action="fundstransferService" method="post">
	<input type="number" placeholder="enter MOBILE NUMBER" name="destMobile" required>
	<h2>ENTER AMOUNT</h2>
	<input type="number" placeholder="enter AMOUNT" name="transferAmount" required>
	<input type="submit" value="TRANSFER">
	</form>
</center>
</body>
</html>