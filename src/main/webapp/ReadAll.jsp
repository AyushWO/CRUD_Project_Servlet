<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.entities.Employee"%>
<%@page import="com.company.controller.EmpController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read all data</title>
</head>
<body style="background-color: #87CEEB">
	<h1>Here's your data:</h1>
	
	<table border="5">
		<thead style="font-weight: bold; ">
				<tr>
					<td>Name</td>
					<td>Skills</td>
					<td>Age</td>
					<td>Salary</td>
					<td>Date of Birth</td>
					<td>Action</td>
				</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${list}" varStatus="loop" >
				<tr>
					<td>${emp.name} </td>
					<%-- <td>"${emp.skills}"</td> --%>
					<td>
						<c:forEach var="emp1" items="${emp.skills}" varStatus="loop" >
							<c:forEach var="emp2" items="${emp1.skills}" varStatus="loop" >
								${emp2}
							</c:forEach>
						</c:forEach>
					</td>
					<td>${emp.age} </td>
					<td>${emp.salary} </td>
					<td>${emp.birthDate} </td>
					<td> <a href="empListById?employeeID=${emp.employeeID}"><button>Update</button></a>
					 &nbsp <a href="deleteEmpById?employeeID=${emp.employeeID}"><button>Delete</button></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<%-- <hr>
	<hr>
	
	<table border="5">
		<thead style="font-weight: bold; ">
				<tr>
					<td>Employee ID</td>
					<td>Skills</td>
					<td>Skills ID</td>
				</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${listSkills}" >
				<tr>
					<td>${emp.employeeID}</td>
					<td>
						<c:forEach var="emp2" items="${emp.skills}" varStatus="loop" >
							${emp2} 
						</c:forEach>
					</td>
					<td>${emp.skillID}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table> --%>
	
	<hr>
	<hr>
	<h1>Please <button><a href="index.jsp">click</a></button> here to go to home page</h1>
</body>
</html>



















<%-- 	<%
		Employee employee = new Employee();
		ArrayList<Employee> list1 = (ArrayList<Employee>) request.getAttribute("list");
		
		Iterator<Employee> it = list1.iterator();
		while (it.hasNext()) {
			System.out.println(it.next()); //for console
			out.println(it.next()); //to display
		}
	%> --%>