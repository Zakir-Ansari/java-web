<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
<link href="<c:url value = "/Resources/style.css" />" rel="stylesheet">
<style type="text/css">
input[type=text], input[type=password], input[type=email], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.form-section {
	width: 50%;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
	margin-left: 25%;
}

#registration-heading {
	text-align: center;
	font-size: 300%;
}
</style>
</head>
<body>
	<h1 id="registration-heading">Registration</h1>
	<div class="form-section">
		<form:form action="registration/do"
			modelAttribute="registrationDetails" method="post">
			<label for="firstName">First Name: </label>
			<br>
			<form:input type="text" id="firstname" path="firstName"
				pattern="[a-zA-Z]+" required="required" />
			<br>
			<label for="lastname">Last Name:</label>
			<br>
			<form:input type="text" id="lastname" path="lastName"
				pattern="[a-zA-Z]+" required="required" />
			<br>
			<label for="email">Email: </label>
			<br>
			<form:input type="email" id="email" path="email" required="required" />
			<br>
			<label for="password">Password:</label>
			<br>
			<form:input type="password" id="password" path="password"
				required="required" />
			<br>
			<input type="submit" value="REGISTER" id="register"
				style="font-weight: bold" />
		</form:form>
	</div>
</body>
</html>