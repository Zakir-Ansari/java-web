<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About</title>
</head>
<body>
	

	<spring:url value="/logout" var="logout" htmlEscape="true"/>
	Email: <p>${ userDetails.email }</p>
	Password: <p>${ userDetails.password }</p>
	<a href="${ logout }">Logout</a><br>
</body>
</html>