package com.company.empService;

import java.util.ArrayList;
import java.util.HashSet;
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

	public HashSet<EmployeeSkills> getEmpSkillsById(int id, String[] skills);

	public boolean updateEmpSkills(EmployeeSkills employee, String[] skill, int id);

	public boolean deleteEmpSkills(int id);
}