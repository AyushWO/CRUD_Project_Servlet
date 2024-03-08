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
	public Employee getEmpById(int id) {
		return empDao.getEmpById(id);
	}

	@Override
	public boolean empUpdate(Employee employee) {
		return empDao.updateEmpDAO(employee);
	}

	@Override
	public boolean empDelete(int id) {
		return empDao.deleteEmpDAO(id);
	}
}
