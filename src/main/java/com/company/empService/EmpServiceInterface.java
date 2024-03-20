package com.company.empService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.company.entities.Employee;
import com.company.entities.EmployeeSkills;

public interface EmpServiceInterface {
	public int empInsert(Employee employee, String skill);

	public ArrayList<Employee> empReadAll();

	public Employee getEmpById(int id);

	public boolean empUpdate(Employee employee);

	public boolean empDelete(int id);
	
//	public int insertEmpSkills(EmployeeSkills employeeSkills);

//	public ArrayList<EmployeeSkills> readAllEmpSkills();

	public ArrayList<EmployeeSkills> getEmpSkillsById(int id);

	public boolean updateEmpSkills(EmployeeSkills employee, String skill);

	public boolean deleteEmpSkills(int id);
}