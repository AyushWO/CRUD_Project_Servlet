<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.entities.Employee"%>
<%@page import="com.company.controller.EmpControl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read all data</title>
</head>
<body>
	<h1>Here's your data:</h1>
	
	<%
		Employee emp = new Employee();
	%>
	
	
	<table border="5">
		<thead style="font-weight: bold; margin-left: auto; margin-right: auto;">
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Skills</td>
					<td>Age</td>
					<td>Salary</td>
					<td>Date of Birth</td>
					<td>Action</td>
				</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${list}" >
				<tr>
					<td>${emp.employeeID} </td>
					<td>${emp.name} </td>
					<td>
						<c:forEach var="emp1" items="${emp.skills}" varStatus="loop" >
							${emp1} 
						</c:forEach>
					</td>
					<td>${emp.age} </td>
					<td>${emp.salary} </td>
					<td>${emp.birthDate} </td>
					<td> <a href="UpdatePage.jsp?employeeID=${emp.employeeID}"><button>Edit</button></a> &nbsp <a href=""><button>Delete</button></a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<%-- <c:forEach var="e" items="${list}" >
		<h1>${e}</h1>
	</c:forEach> --%>
	
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