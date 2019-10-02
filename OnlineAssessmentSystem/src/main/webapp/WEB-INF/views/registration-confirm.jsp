<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Confirmation</title>
<link href="<c:url value = "/Resources/style.css" />" rel="stylesheet">
<style type="text/css">
p {
	font-size: 200%;
}
.content {
  margin-top: 10%;
  width: 50%;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  margin-left: 25%;
  text-align:center;
}

</style>
</head>
<body>
	<div class="content">
	<p>Registered Successful!!!</p>
	<p>${userName}</p>
	<a href="login">LOGIN</a>
	</div>
</body>
</html>