<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.entities.Employee"%>
<%@page import="com.company.entities.EmployeeSkills"%>
<%@page import="com.company.controller.EmpController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update data page</title>
</head>
<body style="background-color: #87CEEB">
	<div
		style="border: solid black 2px; margin-left: 760px; margin-top: 150px; padding: 10px; width: 450px"
		class="d1">
		<form action="updateEmp" method="post">
			<h1>
				<u>Update page</u>
			</h1>
			
			<p style="display: inline-block;">Employee ID that needs to be updated:</p>
			<input name="empid" value="${employee1.employeeID}" placeholder="type here..." type="number" />
			<hr>
			<%-- <p style="display: inline-block;">Skill ID that needs to be updated:</p>
			<input name="skillID" value="${skillSet.skillID }" placeholder="type here..." type="number" />
			<hr> --%>
			<hr>
			<hr>
			<p style="display: inline-block;">Name:</p>
			<input name="EmpName" value="${employee1.name}" placeholder="type here..." type="text" />
			<hr>
			<p style="display: inline-block;">Skills:</p>
				<input name="skills" value="JAVA" ${fn:contains(skillSet, 'JAVA') ? 'checked' : ''} placeholder="type here..." type="checkbox" />JAVA &nbsp &nbsp 
				<input name="skills" value="OOPS" ${fn:contains(skillSet, 'OOPS') ? 'checked' : ''} placeholder="type here..." type="checkbox" />OOPS &nbsp &nbsp 
				<input name="skills" value="COLLECTIONS" ${fn:contains(skillSet, 'COLLECTIONS') ? 'checked' : ''} placeholder="type here..." type="checkbox" />COLLECTIONS &nbsp &nbsp 
				<input name="skills" value="SERVLET&JSP" ${fn:contains(skillSet, 'SERVLET&JSP') ? 'checked' : ''} placeholder="type here..." type="checkbox" />SERVLET&JSP &nbsp &nbsp 
				<input name="skills" value="JDBC" ${fn:contains(skillSet, 'JDBC') ? 'checked' : ''} placeholder="type here..." type="checkbox" />JDBC &nbsp &nbsp 
				<input name="skills" value="SPRING" ${fn:contains(skillSet, 'SPRING') ? 'checked' : ''} placeholder="type here..." type="checkbox" />SPRING &nbsp &nbsp
			<hr>
			<p style="display: inline-block;">Age:</p>
			<input name="EmpAge" value="${employee1.age}" placeholder="type here..." />
			<hr>
			<p style="display: inline-block;">Salary:</p>
			<input name="EmpSalary" value="${employee1.salary}"
				placeholder="type here..." />
			<hr>
			<p style="display: inline-block;">Birth Date:</p>
			<input name="EmployeeDateOfBirth" value="${employee1.birthDate}"
				placeholder="type here..." /> <br> <br>
			<button>UPDATE</button>
			&nbsp &nbsp
			<button>
				<a href="UpdatePage.jsp">Reload</a>
			</button>
		</form>
		<hr>
		<hr>
		<button>
			<a href="index.jsp">Home</a>
		</button>
	</div>
</body>
</html>