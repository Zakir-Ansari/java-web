<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CreditCard-${ Eligibility }</title>
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
</style>
</head>
<body>
	<div id="banner" style="background-color: ${backgroundColor}">
		<h1 id="msg">${ message }</h1>
		${ link }
	</div>
</body>
</html>