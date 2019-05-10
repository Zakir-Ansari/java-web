<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<!-- To make it a secure page -->
	<%
		if(session.getAttribute("userName") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<h2>Welcome ${ userName }</h2>
	
	Go to <a href="other.jsp">Others Page</a>
	<form action="logout">
		<input type="submit" value="logout"/>
	</form>
</body>
</html>