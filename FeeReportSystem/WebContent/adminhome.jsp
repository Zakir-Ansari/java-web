<%
	if(session.getAttribute("user") == null || !session.getAttribute("user").equals("valid")) {
		response.sendRedirect("home.jsp");
	}
%>

<div class="welcome-content">
	<div><h1 class="welcome-heading">Welcome Admin</h1></div>
	<div><p class="welcome-message">You can manage Accountants, Students and all Fee data.</p></div>
</div>