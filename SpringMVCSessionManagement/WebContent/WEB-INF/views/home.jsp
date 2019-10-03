<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
   		
	<spring:url value="/details" var="about" htmlEscape="true"/>
	Welcome <p>${ userDetails.email }</p>
	<a href="${ about }">About you</a><br>
</body>
</html>