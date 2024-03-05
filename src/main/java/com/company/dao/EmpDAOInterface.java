package com.company.dao;

import java.util.ArrayList;
import java.util.List;

import com.company.entities.Employee;

public interface EmpDAOInterface {
	public int insertEmpDAO(Employee employee);

	public ArrayList<Employee> readAllEmpDAO();

	public boolean updateEmpDAO(Employee employee);

	public boolean deleteEmpDAO(int id);
}
