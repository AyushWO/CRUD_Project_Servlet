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
	
	<c:forEach var="e" items="${list}" >
		<h1>${e}</h1>
	</c:forEach>
	
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