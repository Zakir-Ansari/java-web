<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value = "/Resources/table-format.css" />" rel="stylesheet">
<title>All Tests Details</title>
</head>
<body>
	<table>
		<tr>
			<th>Test Date</th>
			<th>Assessment</th>
			<th>Test Marks</th>
			<th>Email Id</th>
			<th>Total Marks</th>
			<th>Result</th>
		</tr>
		<c:forEach items="${results}" var="results" varStatus="tagStatus">
			<tr>
				<td>${results.testDate}</td>
				<td>${results.assessmentName}</td>
				<td>${results.testMarks}</td>
				<td>${results.emailId}</td>
				<td>${results.totalMarks}</td>
				<td>${results.result}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>