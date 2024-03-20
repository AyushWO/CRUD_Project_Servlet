package com.company.empService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.company.controller.EmpController;
import com.company.dao.EmpDAOImpl;
import com.company.dao.EmpDAOInterface;
import com.company.dao.EmpSkillsDAOImpl;
import com.company.dao.EmpSkillsDAOInterface;
import com.company.entities.Employee;
import com.company.entities.EmployeeSkills;

public class EmpServiceImpl implements EmpServiceInterface {
	EmpDAOInterface empDao = new EmpDAOImpl();
	EmpSkillsDAOInterface empSkillsDao = new EmpSkillsDAOImpl();

	@Override
	public int empInsert(Employee employee, String skill) {
		int employeeID = empDao.insertEmpDAO(employee);
		return empSkillsDao.insertEmpSkillsDAO(skill, employeeID);
	}

	@Override
	public ArrayList<Employee> empReadAll() {
		ArrayList<Employee> employees = empDao.readAllEmpDAO();
		ArrayList<EmployeeSkills> employeeSkills = empSkillsDao.readAllEmpSkillsDAO();

		for (Employee employee1 : employees) {
			ArrayList<EmployeeSkills> employeSkillsBlank1 = new ArrayList<EmployeeSkills>();
//			employeSkillsBlank1.clear();
			for (EmployeeSkills employeeSkills1 : employeeSkills) {
				if (employee1.getEmployeeID() == employeeSkills1.getEmployeeID()) {
					employeSkillsBlank1.add(employeeSkills1);
				}
			}
			employee1.setSkills(employeSkillsBlank1);
		}
		return employees;
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

//	@Override
//	public int insertEmpSkills(EmployeeSkills employeeSkills) {
//		return empSkillsDao.insertEmpSkillsDAO(employeeSkills, employeeSkills.getEmployeeID());
//	}

//	 @Override 
//	 public ArrayList<EmployeeSkills> readAllEmpSkills() { return
//	 empSkillsDao.readAllEmpSkillsDAO(); }

	@Override
	public ArrayList<EmployeeSkills> getEmpSkillsById(int id) {
		System.out.println("Message 71, EmpServiceImpl; id: "+id);
		return empSkillsDao.getEmpSkillsById(id);
	}

	@Override
	public boolean updateEmpSkills(EmployeeSkills employeeSkill, String skills) {
		Employee skills1 = new Employee();
		
		System.out.println("Message 79, EmpServiceImpl; employeeSkill.getSkillID(): "+employeeSkill.getSkillID());  //0
		ArrayList<EmployeeSkills> employeeSkillByID = empSkillsDao.getEmpSkillsById(employeeSkill.getSkillID());
		System.out.println("Message 79, EmpServiceImpl; employeeSkill.getSkillID(): "+employeeSkill.getSkillID());
		ArrayList<EmployeeSkills> employeeSkillsUpdated = skills1.getSkills(); // after update
		
		System.out.println("Message 84, EmpServiceImpl, employeeSkillByID: " + employeeSkillByID);
		System.out.println("Message 85, EmpServiceImpl, employeeSkillsUpdated: " + employeeSkillsUpdated);

		for (EmployeeSkills updatedEmployee : employeeSkillByID) {
			if (employeeSkillByID.contains(employeeSkill)) {
				empSkillsDao.insertEmpSkillsDAO(updatedEmployee.getSkill(), employeeSkill.getSkillID());
			}
		}

		for (EmployeeSkills currentEmployee : employeeSkillByID) {
			if (employeeSkillByID.contains(employeeSkill)) {
				empSkillsDao.deleteEmpSkillsDAO(currentEmployee.getSkillID());
			}
		}
		return empSkillsDao.updateEmpSkillsDAO(employeeSkill, skills);
	}

	@Override
	public boolean deleteEmpSkills(int id) {
		return empSkillsDao.deleteEmpSkillsDAO(id);
	}
}

//ArrayList<Employee> newEmployee = employees.stream().flatMap(a->a.get).filter().map().collect();

//assertThat(collected).containsExactly("1", "3");

//Iterator<Employee> employee1 = employees.iterator();
//while (employee1.hasNext()) {
//ArrayList<EmployeeSkills> employeSkillsBlank1 = new ArrayList<EmployeeSkills>();
//Employee employeeObject = employee1.next();
//System.out.println("Message 50, EmpServiceImpl");
//Iterator<EmployeeSkills> employeeSkill1 = employeeSkills.iterator();
//while (employeeSkill1.hasNext()) {
//EmployeeSkills employeeSkillObject = employeeSkill1.next();
//if(employeeObject.getEmployeeID()==employeeSkillObject.getEmployeeID()) {
//	employeeSkills.add(employeeSkillObject);
//}
//}
//employeeObject.setSkills(employeSkillsBlank1);
//}