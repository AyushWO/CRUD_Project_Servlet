package com.company.dao;

import java.util.ArrayList;
import com.company.entities.Employee;

public interface EmpDAOInterface {
	public int insertEmpDAO(Employee employee);

	public ArrayList<Employee> readAllEmpDAO();

	public Employee getEmpById(int id);

	public boolean updateEmpDAO(Employee employee);

	public boolean deleteEmpDAO(int id);
}
