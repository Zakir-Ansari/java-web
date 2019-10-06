<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ title }</title>
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
a:link, a:visited {
  background-color: #ffffff;
  border-radius: 5px;
  border-style: solid;
  border-width: 1px;
  border-color: grey;
  color: black;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  width:90%;
  margin-bottom: 2px;
}

a:hover {
  background-color: LightGray;
}
.content h3 {
	font-size: 40px;
	margin-top: -2px;
}
</style>

</head>
<body>
	<div class=content>
		<spring:url value="/terminateSession" var="terminateSession" htmlEscape="true"/>
		<h1>${ resultMessage }</h1>
		<a href="${ terminateSession }">Exit</a>
	</div>
</body>
</html>