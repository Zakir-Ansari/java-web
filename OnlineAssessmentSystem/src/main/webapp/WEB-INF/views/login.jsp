<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Assessment - Home Page</title>
<link href="<c:url value = "/Resources/style.css" />" rel="stylesheet">
</head>
<body>
	<div class="container">
	<h1 style="text-align: center; font-size: 300%;">Welcome to Online Assessments</h1>
	<h3 style="margin-left:25%; font-size: 200%;">Login</h3>
	<div class="form-section">
	<form:form action="login/do" modelAttribute="userDetails" method="post">	
			<label for="email">Email: </label><br>
			<form:input type="text" id="email" path="email" required="required"/><br>

			<label for="password">Password:</label><br>
			<form:input type="password" id="password" path="password" required="required"/><br>
			<input type="submit" value="Login" id="submit"
					style="font-weight: bold"/>
		</form:form>
		<p>New User?  <a href="register">register here</a> </p>
		</div>
	</div>
</body>
</html>