<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Assessment</title>
<link href="<c:url value = "/Resources/style.css" />" rel="stylesheet">
</head>
<body>

	<h1 style="text-align: center">Spring Assessment</h1>
	<spring:url value="/evaluate/spring/test" var="evaluation" htmlEscape="true"/>
	<div class="question-paper">
		<form:form action="${ evaluation }" modelAttribute="selectedOption" method="post">
			<label id="question" for="question1">Question 1: ${ springAssessment.question1 }</label><br><br>
			 	<form:radiobutton id="Q1-Opt1" path="forQuestion1" value="${ springAssessment.que1Opt1 }" name="Question1"/>${ springAssessment.que1Opt1 }<br>
			  	<form:radiobutton id="Q1-Opt2" path="forQuestion1" value="${ springAssessment.que1Opt2 }" name="Question1"/>${ springAssessment.que1Opt2 }<br>
			   	<form:radiobutton id="Q1-Opt3" path="forQuestion1" value="${ springAssessment.que1Opt3 }" name="Question1"/>${ springAssessment.que1Opt3 }<br>
			    <form:radiobutton id="Q1-Opt4" path="forQuestion1" value="${ springAssessment.que1Opt4 }" name="Question1"/>${ springAssessment.que1Opt4 }<br>
			<br><br><br>    
			<label id="question" for="question2">Question 2: ${ springAssessment.question2 }</label><br><br>
			 	<form:radiobutton id="Q2-Opt1" path="forQuestion2" value="${ springAssessment.que2Opt1 }" name="Question2"/>${ springAssessment.que2Opt1 }<br>
			  	<form:radiobutton id="Q2-Opt2" path="forQuestion2" value="${ springAssessment.que2Opt2 }" name="Question2"/>${ springAssessment.que2Opt2 }<br>
			   	<form:radiobutton id="Q2-Opt3" path="forQuestion2" value="${ springAssessment.que2Opt3 }" name="Question2"/>${ springAssessment.que2Opt3 }<br>
			    <form:radiobutton id="Q2-Opt4" path="forQuestion2" value="${ springAssessment.que2Opt4 }" name="Question2"/>${ springAssessment.que2Opt4 }<br>
			<br><br><br>
			<label id="question" for="question3">Question 3: ${ springAssessment.question3 }</label><br><br>
			 	<form:radiobutton id="Q3-Opt1" path="forQuestion3" value="${ springAssessment.que3Opt1 }" name="Question3"/>${ springAssessment.que3Opt1 }<br>
			  	<form:radiobutton id="Q3-Opt2" path="forQuestion3" value="${ springAssessment.que3Opt2 }" name="Question3"/>${ springAssessment.que3Opt2 }<br>
			   	<form:radiobutton id="Q3-Opt3" path="forQuestion3" value="${ springAssessment.que3Opt3 }" name="Question3"/>${ springAssessment.que3Opt3 }<br>
			    <form:radiobutton id="Q3-Opt4" path="forQuestion3" value="${ springAssessment.que3Opt4 }" name="Question3"/>${ springAssessment.que3Opt4 }<br>
			<br><br><br> 
			<label id="question" for="question4">Question 4: ${ springAssessment.question4 }</label><br><br>
			 	<form:radiobutton id="Q4-Opt1" path="forQuestion4" value="${ springAssessment.que4Opt1 }" name="Question4"/>${ springAssessment.que4Opt1 }<br>
			  	<form:radiobutton id="Q4-Opt2" path="forQuestion4" value="${ springAssessment.que4Opt2 }" name="Question4"/>${ springAssessment.que4Opt2 }<br>
			   	<form:radiobutton id="Q4-Opt3" path="forQuestion4" value="${ springAssessment.que4Opt3 }" name="Question4"/>${ springAssessment.que4Opt3 }<br>
			    <form:radiobutton id="Q4-Opt4" path="forQuestion4" value="${ springAssessment.que4Opt4 }" name="Question4"/>${ springAssessment.que4Opt4 }<br>
			<br><br><br> 
			<label id="question" for="question4">Question 5: ${ springAssessment.question5 }</label><br><br>
			 	<form:radiobutton id="Q5-Opt1" path="forQuestion5" value="${ springAssessment.que5Opt1 }" name="Question5"/>${ springAssessment.que5Opt1 }<br>
			  	<form:radiobutton id="Q5-Opt2" path="forQuestion5" value="${ springAssessment.que5Opt2 }" name="Question5"/>${ springAssessment.que5Opt2 }<br>
			   	<form:radiobutton id="Q5-Opt3" path="forQuestion5" value="${ springAssessment.que5Opt3 }" name="Question5"/>${ springAssessment.que5Opt3 }<br>
			    <form:radiobutton id="Q5-Opt4" path="forQuestion5" value="${ springAssessment.que5Opt4 }" name="Question5"/>${ springAssessment.que5Opt4 }<br>
			<br><br>
			<input id=”submitspring” type="submit" value="Submit Test" /> 
		</form:form>
	</div>
	

</body>
</html>