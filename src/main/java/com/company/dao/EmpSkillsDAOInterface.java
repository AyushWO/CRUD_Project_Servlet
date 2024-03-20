package com.company.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.company.entities.Employee;
import com.company.entities.EmployeeSkills;

public interface EmpSkillsDAOInterface {
	public int insertEmpSkillsDAO(String skill, int id);

	public ArrayList<EmployeeSkills> readAllEmpSkillsDAO();

	public ArrayList<EmployeeSkills> getEmpSkillsById(int id);

	public boolean updateEmpSkillsDAO(EmployeeSkills employee, String skills);

	public boolean deleteEmpSkillsDAO(int id);
}