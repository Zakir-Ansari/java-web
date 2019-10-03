<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<c:if test="${ logout eq 'Success' }">
		<p>Logged out successfully.. </p><br><br>
	</c:if>
	<form:form action="home" modelAttribute="userDetails" method="post">	
			<label for="email">Email: </label><br>
			<form:input type="text" id="email" path="email" required="required"/><br>

			<label for="password">Password:</label><br>
			<form:input type="password" id="password" path="password" required="required"/><br>
			<input type="submit" value="Login" id="submit"
					style="font-weight: bold"/>
		</form:form>
		</div>
	</div>
</body>
</html>