<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CreditCard-Home Page</title>
<style>
#banner {
	background-color: green;
	margin-left: 15%;
	margin-right: 15%;
	margin-top: 10%;
	padding-top: 40px;
	padding-bottom: 40px;
	padding-right: 15%;
	padding-left: 15%;
}
#panNo, table, tr,td {
	border-style: solid;
  	border-width: 1px;
}
table {
	margin-left: 5%;
	margin-right: 5%;
}
</style>
</head>
<body>
	<div id="banner">
		<h1>Check for Credit Card Eligibility</h1>
		<form:form action="checkEligibility" modelAttribute="panDetails" method="post">
			<table>
				<tr>
					<td>
					Enter PAN Number: <form:input id="panNo" path="panNumber" type="text" pattern="[A-Za-z0-9]{10}" title="10 character alpha numeric" required="required" />
					</td>
				</tr>
				<tr>
					<td>
					<input type="submit" value="Check" id="submit" style="font-weight: bold"/>
					</td>
				</tr>
			</table>
		</form:form>

	</div>
</body>
</html>