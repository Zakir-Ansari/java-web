<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hibernate Assessment</title>
<link href="<c:url value = "/Resources/style.css" />" rel="stylesheet">
</head>
<body>
	<%
		if(session.getAttribute("userSession")==null ) {
			System.out.println(session.getAttribute("userSession").toString());
			response.sendRedirect("login");
		}
	%>
	<spring:url value="/evaluate/hibernate/test" var="evaluation" htmlEscape="true"/>
	<div class="question-paper">
		<form:form action="${ evaluation }" modelAttribute="selectedOption" method="post">
			<label id="question" for="question1">Question 1: ${ hibernateAssessment.question1 }</label><br><br>
			 	<form:radiobutton id="Q1-Opt1" path="forQuestion1" value="${ hibernateAssessment.que1Opt1 }" name="Question1"/>${ hibernateAssessment.que1Opt1 }<br>
			  	<form:radiobutton id="Q1-Opt2" path="forQuestion1" value="${ hibernateAssessment.que1Opt2 }" name="Question1"/>${ hibernateAssessment.que1Opt2 }<br>
			   	<form:radiobutton id="Q1-Opt3" path="forQuestion1" value="${ hibernateAssessment.que1Opt3 }" name="Question1"/>${ hibernateAssessment.que1Opt3 }<br>
			    <form:radiobutton id="Q1-Opt4" path="forQuestion1" value="${ hibernateAssessment.que1Opt4 }" name="Question1"/>${ hibernateAssessment.que1Opt4 }<br>
			<br><br><br>    
			<label id="question" for="question2">Question 2: ${ hibernateAssessment.question2 }</label><br><br>
			 	<form:radiobutton id="Q2-Opt1" path="forQuestion2" value="${ hibernateAssessment.que2Opt1 }" name="Question2"/>${ hibernateAssessment.que2Opt1 }<br>
			  	<form:radiobutton id="Q2-Opt2" path="forQuestion2" value="${ hibernateAssessment.que2Opt2 }" name="Question2"/>${ hibernateAssessment.que2Opt2 }<br>
			   	<form:radiobutton id="Q2-Opt3" path="forQuestion2" value="${ hibernateAssessment.que2Opt3 }" name="Question2"/>${ hibernateAssessment.que2Opt3 }<br>
			    <form:radiobutton id="Q2-Opt4" path="forQuestion2" value="${ hibernateAssessment.que2Opt4 }" name="Question2"/>${ hibernateAssessment.que2Opt4 }<br>
			<br><br><br>
			<label id="question" for="question3">Question 3: ${ hibernateAssessment.question3 }</label><br><br>
			 	<form:radiobutton id="Q3-Opt1" path="forQuestion3" value="${ hibernateAssessment.que3Opt1 }" name="Question3"/>${ hibernateAssessment.que3Opt1 }<br>
			  	<form:radiobutton id="Q3-Opt2" path="forQuestion3" value="${ hibernateAssessment.que3Opt2 }" name="Question3"/>${ hibernateAssessment.que3Opt2 }<br>
			   	<form:radiobutton id="Q3-Opt3" path="forQuestion3" value="${ hibernateAssessment.que3Opt3 }" name="Question3"/>${ hibernateAssessment.que3Opt3 }<br>
			    <form:radiobutton id="Q3-Opt4" path="forQuestion3" value="${ hibernateAssessment.que3Opt4 }" name="Question3"/>${ hibernateAssessment.que3Opt4 }<br>
			<br><br><br> 
			<label id="question" for="question4">Question 4: ${ hibernateAssessment.question4 }</label><br><br>
			 	<form:radiobutton id="Q4-Opt1" path="forQuestion4" value="${ hibernateAssessment.que4Opt1 }" name="Question4"/>${ hibernateAssessment.que4Opt1 }<br>
			  	<form:radiobutton id="Q4-Opt2" path="forQuestion4" value="${ hibernateAssessment.que4Opt2 }" name="Question4"/>${ hibernateAssessment.que4Opt2 }<br>
			   	<form:radiobutton id="Q4-Opt3" path="forQuestion4" value="${ hibernateAssessment.que4Opt3 }" name="Question4"/>${ hibernateAssessment.que4Opt3 }<br>
			    <form:radiobutton id="Q4-Opt4" path="forQuestion4" value="${ hibernateAssessment.que4Opt4 }" name="Question4"/>${ hibernateAssessment.que4Opt4 }<br>
			<br><br><br> 
			<label id="question" for="question5">Question 5: ${ hibernateAssessment.question5 }</label><br><br>
			 	<form:radiobutton id="Q5-Opt1" path="forQuestion5" value="${ hibernateAssessment.que5Opt1 }" name="Question5"/>${ hibernateAssessment.que5Opt1 }<br>
			  	<form:radiobutton id="Q5-Opt2" path="forQuestion5" value="${ hibernateAssessment.que5Opt2 }" name="Question5"/>${ hibernateAssessment.que5Opt2 }<br>
			   	<form:radiobutton id="Q5-Opt3" path="forQuestion5" value="${ hibernateAssessment.que5Opt3 }" name="Question5"/>${ hibernateAssessment.que5Opt3 }<br>
			    <form:radiobutton id="Q5-Opt4" path="forQuestion5" value="${ hibernateAssessment.que5Opt4 }" name="Question5"/>${ hibernateAssessment.que5Opt4 }<br>
			<br><br>
			<input id=”submitspring” type="submit" value="Submit Test" /> 
		</form:form>
	</div>
	

</body>
</html>