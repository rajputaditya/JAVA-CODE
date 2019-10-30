<%@page import="org.apache.catalina.startup.SetAllPropertiesRule"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Wallet</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style>
	.btn{
	width:160px;
	margin-top:10px
	}
	</style>
	
</head>
<body>
	<center><h3>SERVICES</h3></center>
	<hr>
	<div class="row" style="margin-left:10px">
		<div class="col-md-2" >
			<form action="addMoney.jsp" method="post">
				<input type="submit" value="FUND DEPOSIT" class="btn btn-outline-warning " name="fundDeposit">
			</form>
		</div>

		<div class="col-md-2">
			<form action="moneyWithdraw.jsp" method="post">
				<input type="submit" value="FUND WITHDRAW" class="btn btn-outline-warning" name="fundWithdraw" >
			</form>
		</div>
		<div class="col-md-2">
			<form action="fundsTransfer.jsp" method="post">
				<input type="submit" value="FUND TRANSFER" class="btn btn-outline-warning" name="fundTransfer">
			</form>
		</div>
		<div class="col-md-2">
			<form action="home" method="post">
				<input type="submit" value="CHECK BALANCE" class="btn btn-outline-warning" name="checkBalance">
			</form>
		</div>
		<div class="col-md-2">
			<form action="printStatement" method="post">
				<input type="submit" value="PRINT STATEMENT" class="btn btn-outline-warning" name="printStatement">
			</form>
		</div>
		<div class="col-md-2">
			<form action="userLogout" method="post">
				<input type="submit" value="LOGOUT" class="btn btn-outline-warning" name="logout">
			</form>
		</div>

	</div>
	<hr>
</body>
</html>