<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to new registration</title>
</head>
<style>
body {background-image:url("cropped-cropped-capgemini_logo_color_rgb.png");
background-repeat:no-repeat;
background-position:center-bottom;
background-size:800px 1000px;}
</style>
<body style="background-color:Aquamarine">
<h1 align="center">New Registration</h1>
<br><br><br><br><br><br><br><br><br><br><br><br>
<div align="center">
	<form action="RegisterationServlet" method="post">
	<table border="2" bgcolor="lightblue">
	<tr>
	<td><h4>Account type:</h4></td><td><select>
  <option value="savings">SAVINGS</option>
  <option value="current">CURRENT</option>
  <option value="salary">SALARY</option>
  <option value="loan">LOAN</option>
</select></td>
	</tr>
	<tr>
		<td><h4>Generate new pin:</h4></td><td><input type="text" name="pinNumber"></td>
	</tr>
	<tr>
		<td><h4>Deposit Initial Amount:</h4></td><td><input type="number" name="initialAccountBalance"></td>
	</tr>
	</table>
	<br>
	<input type="submit" value="REGISTER">
	</form>
</div>
</body>
</html>