<%@ page import="java.sql.*, jsp.*"%>
<%
	//https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_responsive_header
	String email = request.getParameter("email"), password = request.getParameter("password"),
			redirectTo = request.getParameter("redirectTo");
	String email_error = "", password_error = "", login_error = "";
	if (email == null || password == null) {
		email = "";
	} else {
		//If email is filled, validate all the values
		email_error = Validate.validateEmail(email);
		password_error = Validate.validatePassword(password);
		if (email_error.isEmpty() && password_error.isEmpty()) {
			//if errors are all null, means no error
			//Hence, get connection
			Connection c = MySQL.connect();
			if (c != null) {
				long id = MySQL.selectUser(c, email, password);
				if (id != -1) {
					session.setAttribute(Template.USER_ID, id);
				} else {
					login_error = "Invalid email or password";
				}
			} else {
				login_error = "Unable to connect to the database.\nPlease try again later.";
			}
			MySQL.close(c);
		}
	}
	if (redirectTo == null || redirectTo.isEmpty()) {
		redirectTo = "index.jsp";
	}
	if (session.getAttribute(Template.USER_ID) != null) {
		response.sendRedirect("overview.jsp"); //Page Specifier
	}
%>


<%@ page import="jsp.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
<link type="text/css" rel="stylesheet" href="css/template.css" />
</head>

<script type="text/javascript">
	$(function() {
		$("#login").button();
		$("[name = 'email']").focusout(validateEmail).keyup(validateEmail);
		$("[name = 'password']").focusout(validatePassword).keyup(
				validatePassword);
	});
</script>
</head>
<body>
	<div id="container" class="ui-widget ui-widget-content ui-corner-all"></div>
	<div id="header" class="ui-widget-header ui-corner-all">
		<div id="navigation_bar">
		<ul>
			<%=Template.getNavigationBar()%>
		</ul>
		</div>
		<div id="content">
			<form method="post" action="login.jsp">
				<table>
					<tr>
						<td></td>
						<td>Log In</td>
						<td></td>
					</tr>
					<tr>
						<td class="align-right">Email</td>
						<td><input type="text" name="email" data-validate="email"
							value="<%=email%>" /></td>
						<td id="email_error"><%=email_error%></td>
					</tr>
					<tr>
						<td class="align-right">Password</td>
						<td><input type="password" name="password"
							data-validate="password" /></td>
						<td id="password_error"><%=password_error%></td>
					</tr>
					<tr>
						<td><input type="hidden" value="<%=redirectTo%>"
							name="redirectTo" /></td>
						<td><input type="submit" id="login" value="Log In" /></td>
						<td id="log_error"><%=login_error%></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="footer"><%=Template.getFooter()%></div>
</body>
</html>