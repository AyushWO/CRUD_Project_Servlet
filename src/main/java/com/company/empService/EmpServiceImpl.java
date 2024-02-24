package com.company.empService;

import java.util.ArrayList;
import java.util.List;

import com.company.dao.EmpDAOImpl;
import com.company.dao.EmpDAOInterface;
import com.company.entities.Employee;

public class EmpServiceImpl implements EmpServiceInterface {
	EmpDAOInterface empDao = new EmpDAOImpl();

	@Override
	public void empCreate(Employee employee) {
		empDao.insertEmpDAO(employee);
	}

	@Override
	public ArrayList<Employee> empReadAll() {
		return empDao.readAllEmpDAO();
	}

	@Override
	public void empUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void empDelete() {
		// TODO Auto-generated method stub

	}

}
