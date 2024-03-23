package com.company.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.company.entities.Employee;
import com.company.entities.EmployeeSkills;

public interface EmpSkillsDAOInterface {
	public int insertEmpSkillsDAO(EmployeeSkills employeeSkills, String skill, String[] skills, int id);

	public ArrayList<EmployeeSkills> readAllEmpSkillsDAO();

	public HashSet<EmployeeSkills> getEmpSkillsById(int id, String[] skills);

	public boolean updateEmpSkillsDAO(EmployeeSkills employee, String[] skills, int id);

	public boolean deleteEmpSkillsDAO(int id);
}