<%@ page import="java.sql.*, jsp.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%="Hello World"%>
	<%
	Connection c = MySQL.connect();
	out.print("<h1>Below is your mysql connection token</h1>");
	out.print(c);
	MySQL.close(c);
	%>
</body>
</html>