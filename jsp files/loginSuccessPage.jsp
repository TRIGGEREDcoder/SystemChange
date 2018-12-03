<%@page session="false" %>
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
<body  style="background-color:Aquamarine">
<h1 align="center">Services Available: DEPOSIT / WITHDRAWAL / FUND TRANSFER</h1>
<br><br><br><br><br><br><br><br><br><br><br><br>
<%
	HttpSession session= request.getSession();
	Account account= null;
	if(session==null)
		response.sendRedirect("HomePage.jsp");	
	else
		account=(Account)session.getAttribute("account");
%>
<div align="center">
<form action="LoginServicesServlet" method="post">
<input type="number" name="depositAmount">
<input type="submit" value="Deposit Amount" name="deposit"><br><br>
<input type="number" name="withdrawAmount">
<input type="submit" value="Withdraw Amount" name="withdraw">
<br><br><br>
<input type="submit" value="Fund Transfer" name="fundTransfer">
</form>
</div>
</body>
</html>