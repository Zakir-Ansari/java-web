<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fee Report</title>
<link rel="stylesheet" href="css/nav-bar.css">
</head>
<body>
	<!-- Navigation Bar -->
	<nav class="nav-bar">
		<ul>
			<li><h2 class="brand">FEE REPORT</h2></li>
			<li><a class="active" href="#home">Home</a></li>
		</ul>
	</nav>
	<div style="font-size: 10px; color: red;"><p>
	<%
		if (request.getAttribute("no_user_logged_in") != null) {
	%>
	Please login first!!
	<%
		}
	%>
	
	</p></div>
	<!-- Admin login form -->
	<h4>Admin Login Form</h4>
	<form action="AdminLogin" method="post">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" required /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required /></td>
				<td>
					<div class="error" style="font-size: 10px; color: red;">
						<p>
							<%
								if (request.getAttribute("error") != null) {
							%>
							<%=request.getAttribute("error")%>
							<%
								}
							%>
						</p>
					</div>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>


	<!-- Accountant login form -->
	<h4>Accountant Login Form</h4>
	<form action="AccountantLogin" method="post">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" required /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
	<div class="footer">
		<p>&copy;Copyright 2019. FeeReport.com | Creator: Zakir</p>
	</div>

</body>
</html>