package com.company.empService;

import java.util.ArrayList;
import java.util.List;

import com.company.entities.Employee;

public interface EmpServiceInterface {
	public void empCreate(Employee employee);

	public ArrayList<Employee> empReadAll();

	public void empUpdate();

	public void empDelete();
}
