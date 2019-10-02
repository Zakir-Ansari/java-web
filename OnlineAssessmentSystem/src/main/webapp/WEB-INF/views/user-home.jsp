<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select Reports</title>
<link href="<c:url value = "/Resources/style.css" />" rel="stylesheet">
<style type="text/css">
.content {
	width: 50%;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
	margin-left: 25%;
	text-align: center;
	margin-top: 40px;
}
.content a {
	font-weight: bolder;
	font-size: 25px;
}
.content h3 {
	font-size: 40px;
	margin-top: -2px;
}
</style>

</head>
<body>
	<%
		if(session.getAttribute("authentication") == null) {
			response.sendRedirect("/login");
		}
	%>
	<spring:url value="/login" var="login" htmlEscape="true"/>
	<spring:url value="/terminateSession" var="terminateSession" htmlEscape="true"/>
	<spring:url value="/springAssessment" var="springAssessment" htmlEscape="true"/>
	<spring:url value="/hibernateAssessment" var="hibernateAssessment" htmlEscape="true"/>
	<div class="content">
	<c:if test="${ current_user eq 'admin' }">
		<h3>Select Reports</h3>
		<a href="#">View list of all candidates</a><br>
		<a href="#">View listof all test taken</a><br>
		<a href="#">Logout</a>
	</c:if>
	
	<c:if test="${ current_user eq 'candidate' }">
		<div id="msg">Select the Test</div><br>
		<a href="${ springAssessment }">Spring Assessment</a><br>
		<a href="${ hibernateAssessment }">Hibernate Assessment</a><br>
		<a href="${ terminateSession }">Logout</a><br>
	</c:if>
	<c:if test="${ current_user eq 'invalid' }">
		<h1 id=”msg”>Sorry you are not a registered User !!!</h1>
		<a href=${ login }>Home Page</a>
	</c:if>
	<c:if test="${ current_user eq 'invalid_password' }">
		<h1 id=”msg”>Sorry your Password is Wrong !!! Login again !!!</h1>
		<a href="${ login }">login again</a>
	</c:if>
	</div>
</body>
</html>