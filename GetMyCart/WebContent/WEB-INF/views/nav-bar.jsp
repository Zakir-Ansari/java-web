<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<a class="navbar-brand" href="about">GetMyCart</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			
			<c:if test="${this_page eq 'signup' or this_page eq 'home'}">
			<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
			</c:if>
			<c:if test="${this_page eq 'login' or this_page eq 'home'}">
			<li class="nav-item"><a class="nav-link" href="sign-up">Sign-Up</a></li>
			</c:if>
			<li class="nav-item"><a class="nav-link" href="#">Contact Us</a></li>
		</ul>
	</div>
</nav>
<br>
