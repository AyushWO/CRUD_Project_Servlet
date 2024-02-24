<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.entities.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Here's your data:</h1>
	<c:set var="employee" value="${list}" />
	<%-- <%
	Employee employee = new Employee();
	ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("list");
	Iterator<Employee> it = list.iterator();
	while (it.hasNext()) {
		System.out.println(it.next());
		out.println(it.next());
	}
	%> --%>
	
</body>
</html>