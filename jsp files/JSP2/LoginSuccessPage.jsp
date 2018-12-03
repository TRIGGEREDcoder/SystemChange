<%@page session="false"%>
<%@page import="com.cg.banking.beans.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Successful</title>
</head>
<style>
body {background-image:url("cropped-cropped-capgemini_logo_color_rgb.png");
background-repeat:no-repeat;
background-position:center-bottom;
background-size:800px 1000px;}
</style>
<body style="background-color:Aquamarine">
<br><br><br><br><br><br><br><br><br><br><br><br>
	<div align="center">
		<h2>Choose Service:</h2>
		<form action="DepositAmountServlet" method="post">
			<input type="number" name="depositAmount"><input type="submit" value="Deposit amount" name="deposit"><br>
			</form>
			<form action="WithdrawAmountServlet" method="post">
			<input type="number" name="withdrawAmount"><input type="submit" value="Withdraw amount" name="withdraw"> <br>
			</form>
			<br>
		
		<form action="FundTransferDetailsPage.jsp" method="post">
			<input type="submit" name="fundTransfer" value="FUND TRANSFER">
		</form>
		<form action="GenerateNewPinNumberPage.jsp" method="post">
			<input type="submit" name="generatePin" value="GENERATE NEW PIN">
		</form>
		<!-- <form action="DisplayTransactionServlet" method="post">
			<input type="submit" name="displayTransaction" value="DISPLAY ALL TRANSACTIONS">
		</form> -->
		
		${Message}
	</div>
</body>
</html>