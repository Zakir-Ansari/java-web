<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GetMyCart | Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link href="<c:url value="/Resources/style.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="nav-bar.jsp" />

<div class = "login-form">
<form:form class="text-center border border-light p-5" action="checkEligibility" modelAttribute="loginDetails" method="post">
    <p class="h4 mb-4">Login</p>
    
    <!-- Name -->
    <form:input type="email" id="defaultSubscriptionFormPassword" class="form-control mb-4" placeholder="Email" path="email"/>
    <!-- Email -->
    <form:input type="password" id="defaultSubscriptionFormEmail" class="form-control mb-4" placeholder="Password" path="password"/>
    <!-- Sign in button -->
    <button class="btn btn-info btn-block" type="submit">Sign in</button>
</form:form>
</div>

</body>
</html>