package com.company.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.empService.EmpServiceImpl;
import com.company.empService.EmpServiceInterface;
import com.company.entities.Employee;
import com.company.entities.EmployeeSkills;

public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee employee = new Employee();
	EmployeeSkills employeeSkills = new EmployeeSkills();
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
		System.out.println("Do post");
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
		int age = Integer.parseInt(request.getParameter("EmpAge"));
		int salary = Integer.parseInt(request.getParameter("EmpSalary"));
		String birthDate = request.getParameter("EmployeeDateOfBirth");

		// employee.setEmployeeID(empId);
		employee.setName(name);
		employee.setAge(age);
		employee.setSalary(salary);
		employee.setBirthDate(birthDate);
		
//		String[] skill = request.getParameterValues("skills");
//		System.out.println("message 76, EmpController -> "+skill);  --->[Ljava.lang.String;@755f8862
		
		String[] skillArray = request.getParameterValues("skills");
		String skill = String.join(", ", skillArray);
		employeeSkills.setSkill(skill);

		service.empInsert(employee, skill);
//		service.insertEmpSkills(employeeSkills);
		
		readAllEmpController(request, response);
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
		ArrayList<EmployeeSkills> skillSet = new ArrayList<EmployeeSkills>();
		int empId = Integer.parseInt(request.getParameter("employeeID"));
		System.out.println("Message 106, EmpController; empID: "+empId);
		Employee employee1 = service.getEmpById(empId);
		
		request.setAttribute("employee1", employee1);
		
		System.out.println("Message 111, EmpController; skillSet: "+skillSet);
		skillSet = service.getEmpSkillsById(empId);
		System.out.println("Message 113, EmpController; skillSet: "+skillSet);
		
		request.setAttribute("skillSet", skillSet);
		
		RequestDispatcher rd = request.getRequestDispatcher("UpdatePage.jsp");
		rd.forward(request, response);
	}
	
	protected void updateEmpControllerById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Message 123, EmpController");
//		int empId = Integer.parseInt(request.getParameter("employeeID"));
		int employeeID = Integer.parseInt(request.getParameter("empid"));
//		int skillID = Integer.parseInt(request.getParameter("skillID"));
		System.out.println("Message 126, EmpController");
		String name = request.getParameter("EmpName");
		System.out.println("Message 128, EmpController");
		String[] skillArray = request.getParameterValues("skills");
		System.out.println("Message 130, EmpController");
		String skill = String.join(", ", skillArray);
		System.out.println("Message 132, EmpController; skill: "+skill);
		int age = Integer.parseInt(request.getParameter("EmpAge"));
		System.out.println("Message 136, EmpController");
		int salary = Integer.parseInt(request.getParameter("EmpSalary"));
		System.out.println("Message 138, EmpController");
		String birthDate = request.getParameter("EmployeeDateOfBirth");
		
		System.out.println("Message 141, EmpController");
		employee.setEmployeeID(employeeID);
		System.out.println("Message 143, EmpController");
//		employeeSkills.setSkillID(skillID);
		employee.setName(name);
		System.out.println("Message 146, EmpController");
		employeeSkills.setSkill(skill);
		System.out.println("Message 148, EmpController; skill: "+skill);
		employee.setAge(age);
		employee.setSalary(salary);
		System.out.println("Message 151, EmpController");
		employee.setBirthDate(birthDate);
		
		System.out.println("Message 154, EmpController");
		service.empUpdate(employee);
		System.out.println("Message 155, EmpController");
		service.updateEmpSkills(employeeSkills, skill);
		
		System.out.println("Message 159, EmpController; skill: "+skill);
		readAllEmpController(request, response);
		
		System.out.println("Message 162, EmpController");
	}
	
	protected void deleteEmpControllerById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("employeeID"));
		service.empDelete(id);
		
		readAllEmpController(request, response);
	}
}
