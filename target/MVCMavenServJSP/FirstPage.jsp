<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registration Page</title>
</head>
<body>
	<div style="border: solid black 2px; margin-left:760px; margin-top: 150px; padding: 10px; width: 450px " class="d1">
		<form action="insert-emp" method="post">
			<h1 style="margin-left:70px "><U>Registration Form</U></h1>
			<!-- <p style="display: inline-block;">Employee ID: </p><input name="empid" placeholder="type here..." type="number" /> -->
			<hr>
			<p style="display: inline-block;">Name: </p><input name="EmpName" placeholder="type here..." type="text"/>
			<hr>
			<p style="display: inline-block;">Skills: </p><input name="skills" value="JAVA" placeholder="type here..." type="checkbox"/>JAVA &nbsp &nbsp
														  <input name="skills" value="OOPS" placeholder="type here..." type="checkbox"/>OOPS &nbsp &nbsp
														  <input name="skills" value="Collections" placeholder="type here..." type="checkbox"/>Collections &nbsp &nbsp
														  <input name="skills" value="SERVLET&JSP" placeholder="type here..." type="checkbox"/>SERVLET&JSP &nbsp &nbsp
														  <input name="skills" value="JDBC" placeholder="type here..." type="checkbox"/>JDBC &nbsp &nbsp
														  <input name="skills" value="SPRING" placeholder="type here..." type="checkbox"/>SPRING &nbsp &nbsp  
			<hr>
			<p style="display: inline-block;">Age: </p><input name="EmpAge" placeholder="type here..." />
			<hr>
			<p style="display: inline-block;">Salary: </p><input name="EmpSalary" placeholder="type here..." />
			<hr>
			<p style="display: inline-block;">Birth Date: </p><input name="EmployeeDateOfBirth" placeholder="type here..." />
			<br>
			<br>
			<button>Insert</button>
		</form>
		<hr><hr>
		<button> <a href="emp-list">ReadAllData</a> </button>
	</div>
</body>
</html>