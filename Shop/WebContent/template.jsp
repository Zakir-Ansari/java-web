<%@ page import="jsp.*"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<link type="text/css" rel="stylesheet" href="css/jquery-ui.css" />
<title>Template</title>
<link type="text/css" rel="stylesheet" href="css/template.css">
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
		<div id="content">Content</div>
	</div>
	<div id="footer"><%=Template.getFooter()%></div>
</body>
</html>