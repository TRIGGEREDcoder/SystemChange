<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web-Banking</title>
</head>
<style>
body {background-image:url("cropped-cropped-capgemini_logo_color_rgb.png");
background-repeat:no-repeat;
background-position:center-bottom;
background-size:800px 1000px;}
</style>
<body style="background-color:Aquamarine">
<h1 align="center">Welcome to Web Banking...Happy to serve you.</h1>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div align="center">
<h2></h2>
<form action="LoginServlet" method="post">
<table border="2" bgcolor="lightblue">
<tr>
	<td><h4> Account Number</h4></td><td><input type="text" name="accountNo"></td>
<tr>
	<td><h4> Pin  Number</h4></td><td><input type="password" name="pinNumber"></td>
</tr>
</table>
<br><br>
<input type="submit" value="LOGIN">
</form>
<h5>Or</h5>
<form action="RegisterationPage.jsp" method="post">
<input type="submit" value="NEW REGISTRATION">
</form>
</div>
</body>
</html>