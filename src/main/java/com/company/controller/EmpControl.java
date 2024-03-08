package com.company.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.empService.EmpServiceImpl;
import com.company.empService.EmpServiceInterface;
import com.company.entities.Employee;

public class EmpControl extends HttpServlet {
	Employee employee = new Employee();
	EmpServiceInterface service = new EmpServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Do get");
		String path = request.getServletPath();
		switch (path) {
		case "/empAllList":
			readAllEmpController(request, response);
			break;
			
		case "/empListById":
			readEmpByIdController(request, response);
			break;
			
		case "/deleteEmpById":
			deleteEmpControllerById(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		switch (path) {
		case "/insertEmp":
				insertEmpController(request, response);
			break;

		case "/updateEmp":
				updateEmpControllerById(request, response);
			break;

		default:
			System.out.println("Nothing is there...");
		}
	}

	protected void insertEmpController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		int empId = Integer.parseInt(request.getParameter("empid"));
		String name = request.getParameter("EmpName");
		String[] skills = request.getParameterValues("skills");
		String[] skillArray = request.getParameterValues("skills");
		String skill = String.join(", ", skillArray);
		int age = Integer.parseInt(request.getParameter("EmpAge"));
		int salary = Integer.parseInt(request.getParameter("EmpSalary"));
		String birthDate = request.getParameter("EmployeeDateOfBirth");

		// employee.setEmployeeID(empId);
		employee.setName(name);
		employee.setSkills(skills);
		employee.setSkill(skill);
		employee.setAge(age);
		employee.setSalary(salary);
		employee.setBirthDate(birthDate);

		service.empCreate(employee);
		
		readAllEmpController(request, response);
//		RequestDispatcher rd = request.getRequestDispatcher("/SuccessInsert.jsp");
//		rd.forward(request, response);
	}

	protected void readAllEmpController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Employee> list = service.empReadAll();
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ReadAll.jsp");
		rd.forward(request, response);
	}
	
	protected void readEmpByIdController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("employeeID"));
		Employee employee1 = service.getEmpById(empId);
		request.setAttribute("employee1", employee1);
		
		RequestDispatcher rd = request.getRequestDispatcher("UpdatePage.jsp");
		rd.forward(request, response);
	}
	
	protected void updateEmpControllerById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int employeeID = Integer.parseInt(request.getParameter("empid"));
		String name = request.getParameter("EmpName");
//		String[] skills = request.getParameterValues("skills");
		String[] skillArray = request.getParameterValues("skills");
		String skill = String.join(", ", skillArray);
		int age = Integer.parseInt(request.getParameter("EmpAge"));
		int salary = Integer.parseInt(request.getParameter("EmpSalary"));
		String birthDate = request.getParameter("EmployeeDateOfBirth");
		
		employee.setEmployeeID(employeeID);
		employee.setName(name);
		employee.setSkill(skill);
		employee.setAge(age);
		employee.setSalary(salary);
		employee.setBirthDate(birthDate);
		
		service.empUpdate(employee);
		
		readAllEmpController(request, response);
//		RequestDispatcher rd = request.getRequestDispatcher("/SuccessUpdated.jsp");
//		rd.forward(request, response);
	}
	
	protected void deleteEmpControllerById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("employeeID"));
		service.empDelete(id);
		
		readAllEmpController(request, response);
//		RequestDispatcher rd = request.getRequestDispatcher("ReadAll.jsp");
//		rd.forward(request, response);
	}
}
