<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Keep the page ideal for 20 seconds and try reloading the page.
	<br>You will be redirected to home page automatically.<br>
	
	<%
		if(session != null) {
			if(session.getAttribute("user") != null) {
				String name = (String) session.getAttribute("user");
				out.print("Hello, " + name + "Welcome to your profile.");
			}
			else {
				response.sendRedirect("login.jsp");
			}
		}
	%>
	<br>
	<br>
	<form action="Logout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>