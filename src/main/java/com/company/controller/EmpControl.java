package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.EmpDAOInterface;
import com.company.empService.EmpServiceImpl;
import com.company.empService.EmpServiceInterface;
import com.company.entities.Employee;

public class EmpControl extends HttpServlet {
	Employee employee = new Employee();
	EmpServiceInterface service = new EmpServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/emp-list":
			System.out.println("Message 29");
			readAllEmpController(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		switch (path) {
		case "/insert-emp":
			insertEmpController(request, response);
			break;

		case "/updateEmp":

			break;

		case "/deleteEmp":

			break;

		default:
		}
	}

	protected void insertEmpController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		int empId = Integer.parseInt(request.getParameter("empid"));
		String name = request.getParameter("EmpName");
		String[] skills = request.getParameterValues("skills");
		int age = Integer.parseInt(request.getParameter("EmpAge"));
		int salary = Integer.parseInt(request.getParameter("EmpSalary"));
		String birthDate = request.getParameter("EmployeeDateOfBirth");

		// employee.setEmployeeID(empId);
		employee.setName(name);
		employee.setSkills(skills);
		employee.setAge(age);
		employee.setSalary(salary);
		employee.setBirthDate(birthDate);

		service.empCreate(employee);

		RequestDispatcher rd = request.getRequestDispatcher("/Success.jsp");
		rd.forward(request, response);
	}

	protected void readAllEmpController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Employee> list = service.empReadAll();
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("/ReadAll.jsp");
		rd.forward(request, response);
	}
}
















//response.setContentType("text/html");

//PrintWriter out = response.getWriter();
//out.println("<p style=\"color: blue;\">Employee ID: "+empId+"</p>");
//out.println("<h1>Hello " + name + ".</h1>");
//out.print("<h1>These are the skills mentioned by you: </h1>");
//for(int i=0; i<skills.length; i++) {
//	String[] s = employee.getSkills();
//	out.print("<h1>"+s[i]+"</h1>");
//System.out.println(s[i]);
//}
//out.println("<h1 >Your age is "+age+".</h1>");
//out.println("<h1>Your salary is "+salary+".</h1>");
//out.println("<h1>Your Birth Date is "+bd+".</h1>");
