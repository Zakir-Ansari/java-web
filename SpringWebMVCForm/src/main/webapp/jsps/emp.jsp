<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<form action="../store" method="post">
		Eno: <input type="text" name="eno"/>
		Name: <input type="text" name="name"/>
		Salary: <input type="text" name="salary"/>
		<input type="submit" value="store"/>
	</form>
</body>
</html>