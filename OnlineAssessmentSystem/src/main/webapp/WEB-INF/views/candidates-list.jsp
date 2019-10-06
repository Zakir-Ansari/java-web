<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All User Details</title>
<link href="<c:url value = "/Resources/table-format.css" />" rel="stylesheet">
</head>
<body>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email ID</th>
			<th>User Type</th>
		</tr>
		<c:forEach items="${candidatesList}" var="candidate" varStatus="tagStatus">
			<tr>
				<td>${candidate.firstName}</td>
				<td>${candidate.lastName}</td>
				<td>${candidate.email}</td>
				<td>${candidate.userType}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>