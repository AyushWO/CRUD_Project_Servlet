package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.company.entities.Employee;

public class EmpDAOImpl implements EmpDAOInterface {
	@Override
	public int insertEmpDAO(Employee employee1) {
		// String q = "insert into EmployeeTable values(?,?,?,?,?,?)";
		String q = "insert into EmployeeTable (name, skills, age, salary, birthDate) values (?, ?, ?, ?, ?)";
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			PreparedStatement stmt = con.prepareStatement(q);
			stmt.setString(1, employee1.getName());
			stmt.setInt(3, employee1.getAge());
			stmt.setInt(4, employee1.getSalary());
			stmt.setString(5, employee1.getBirthDate());
			stmt.setString(2, employee1.getSkill());
//			String empSkill = employee1.getSkills();
//			for (int i = 0; i < empSkill.length; i++) {
//				stmt.setString(2, empSkill[i].join(", ", empSkill));
//			}
			result = stmt.executeUpdate();

			stmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		} finally {

		}
		System.out.println("Insert working fine in dao");
		return 0;
	}

	@Override
	public ArrayList<Employee> readAllEmpDAO() {
		ArrayList<Employee> list = new ArrayList<Employee>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			String q = "select * from EmployeeTable";
			stmt = con.prepareStatement(q);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeID(rs.getInt("employeeID"));
				employee.setName(rs.getString("name"));
				String skillsString = rs.getString("skills");
				String[] skillsArray = skillsString.split(", ");
				employee.setSkills(skillsArray);
				employee.setAge(rs.getInt("age"));
				employee.setSalary(rs.getInt("salary"));
				employee.setBirthDate(rs.getString("birthDate"));

				list.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Add all data working fine in dao");
		return list;
	}

	@Override
	public Employee getEmpById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Employee employee1 = new Employee();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			String q = "select * from EmployeeTable where employeeID=?";
			stmt = con.prepareStatement(q);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				employee1.setEmployeeID(rs.getInt("employeeID"));
				employee1.setName(rs.getString("name"));
//				String[] skillsArray = skillsString.split(", ");
				String skillsString = rs.getString("skills");
				employee1.setSkill(skillsString);
				employee1.setAge(rs.getInt("age"));
				employee1.setSalary(rs.getInt("salary"));
				employee1.setBirthDate(rs.getString("birthDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Add data by ID working fine in dao");
		return employee1;
	}

	@Override
	public boolean updateEmpDAO(Employee employee) {
		boolean isUpdated = false;
		try {
			System.out.println("Message 115 in EmpDAOImpl");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			String q = "update EmployeeTable set name=?, skills=?, age=?, salary=?, birthDate=? where employeeID=?";
			PreparedStatement stmt = con.prepareStatement(q);
			System.out.println("Message 120 in EmpDAOImpl");
			stmt.setString(1, employee.getName());
			System.out.println("Message 122 in EmpDAOImpl");
			stmt.setString(2, employee.getSkill());
//			String[] empSkill = employee.getSkills();
//			for (int i = 0; i < empSkill.length; i++) {
//				stmt.setString(2, empSkill[i].join(", ", empSkill));
//			}
			System.out.println("Message 127 in EmpDAOImpl");
			stmt.setInt(3, employee.getAge());
			stmt.setInt(4, employee.getSalary());
			stmt.setString(5, employee.getBirthDate());
			stmt.setInt(6, employee.getEmployeeID());
			System.out.println("Message 132 in EmpDAOImpl");
			int count = stmt.executeUpdate();
			if (count == 1) {
				System.out.println("Message 135 in EmpDAOImpl");
				isUpdated = true;
			}
		} catch (Exception e) {
			System.out.println("Message 139 in EmpDAOImpl");
			System.out.println(e);
		}
		System.out.println("update data working fine in dao");
		return isUpdated;
	}

	@Override
	public boolean deleteEmpDAO(int id) {
		boolean isDeleted = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			String q = "delete from EmployeeTable where employeeID=?";
			PreparedStatement stmt = con.prepareStatement(q);
			stmt.setInt(1, id);
			int count = stmt.executeUpdate();
			if (count == 1) {
				isDeleted = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("delete data working fine in dao");
		return isDeleted;
	}
}
