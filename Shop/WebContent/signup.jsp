<%@ page import="jsp.*,  java.sql.*"%>
<%!%>
<%
	String email = request.getParameter("email"), password = request.getParameter("password"),
			birthday = request.getParameter("birthday");
	String email_error = "", password_error = "", birthday_error = "", sign_up_error = "";
	if (email == null) {
		//first rendering
		email = "";
		birthday = "";
	} else {
		//If email is filled, validate all the values
		email_error = Validate.validateEmail(email);
		password_error = Validate.validatePassword(password);
		birthday_error = Validate.validateBirthday(birthday);
		if (email_error.isEmpty() && password_error.isEmpty() || birthday_error.isEmpty()) {
			//if errors are all null, means no error
			//Hence, get connection
			Connection c = MySQL.connect();
			if (c != null) {
				long id = MySQL.insertUser(c, email, password, birthday);
				if (id != -1) {
					session.setAttribute(Template.USER_ID, id);
				} else {
					email_error = "That email is already in use.";
				}
			} else {
				sign_up_error = "Unable to connect to the database.\nPlease try again later.";
			}
			MySQL.close(c);
		}
	}
%>


<!DOCTYPE html>
<html>
<head>
<title>Sign Up</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-ui-min.js"></script>
<link type="text/css" rel="stylesheet" href="css/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="css/jquery-ui-min.css" />
<link type="text/css" rel="stylesheet" href="css/template.css">
<link type="text/css" rel="stylesheet" href="css/signup.css">
<script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript" src="js/signup.js"></script>
</head>
<body>
	<div id="container" class="ui-widget ui-widget-content ui-corner-all">
		<div id="header" class="ui-widget-header ui-corner-all">
			<div id="navigation_bar">
				<%=Template.getNavigationBar()%>
			</div>
			<div id="account">
				<%=Template.getAccountLinks(session.getAttribute(Template.USER_ID))%>
				<!-- setAttribute() method adds the specified attribute to an element, and gives it the specified value -->
			</div>
		</div>
		<div id="content">
			<form method="post" action="signup.jsp">
				<table>
					<tr>
						<td>Email</td>
						<!-- Below we are passing the value of email from Java code -->
						<td><input type="text" name="email" value="<%=email%>" /></td>
						<td id="email_error"><%=email_error%></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" /></td>
						<td id="password_error"><%=password_error%></td>
					</tr>
					<tr>
						<td>Birthday</td>
						<!-- Below we are passing the value of birthday from Java code -->
						<td><input type="text" name="birthday" id="birthday"
							value="<%=birthday%>" /></td>
						<td><%=birthday_error%></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" id="sign_up" value="Sign Up" /></td>
						<td><%=sign_up_error%></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="footer"><%=Template.getFooter()%></div>
</body>
</html>