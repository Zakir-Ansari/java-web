<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Others</title>
</head>
<body>
	<!-- Below code makes this page secured. -->
	<%
		if(session.getAttribute("userName") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<h3>This is page: other</h3>
	And it is secured page.
</body>
</html>