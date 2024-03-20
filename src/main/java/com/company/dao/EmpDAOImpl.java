package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.company.entities.Employee;
import com.company.entities.EmployeeSkills;

public class EmpDAOImpl implements EmpDAOInterface {
	@Override
	public int insertEmpDAO(Employee employee1) {
		// String q = "insert into EmployeeTable values(?,?,?,?,?,?)";
		String q = "insert into EmployeeTable (name, age, salary, birthDate) values (?, ?, ?, ?)";
		EmployeeSkills employeeSkills = new EmployeeSkills();
		int result = 0;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			PreparedStatement stmt = con.prepareStatement(q, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, employee1.getName());
			stmt.setInt(2, employee1.getAge());
			stmt.setInt(3, employee1.getSalary());
			stmt.setString(4, employee1.getBirthDate());
//			stmt.setString(2, employee1.getSkill());
//			String[] empSkill = employeeSkills.getSkills();
//			for (int i = 0; i < empSkill.length; i++) {
//				stmt.setString(2, empSkill[i].join(", ", empSkill));
//			}
			result = stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				result=rs.getInt(1);
				System.out.println("Message 43, EmpDaoImpl, ReturnGeneratedKey-> "+result);
			}
			stmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("Message 47, EmpDaoImpl");
			e.printStackTrace();
		}
		System.out.println("Insert working fine in dao");
		System.out.println("Message 54, EmpDaoImpl, ReturnGeneratedKey-> "+result);
		return result; 
	}
	
//	stmt.executeUpdate("INSERT INTO authors VALUES (, '"+ string.get(1) +"')", Statement.RETURN_GENERATED_KEYS);
//	ResultSet rs = stmt.getGeneratedKeys();
//	rs.next();
//	long pk = rs.getLong(1);

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
//				String skillsString = rs.getString("skills");
//				String[] skillsArray = skillsString.split(", ");
//				employee.setSkills(skillsArray);
//				employee.setSkills(rs.getString("skills"));
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
//				String skillsString = rs.getString("skills");
//				employee1.setSkill(skillsString);
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
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			String q = "update EmployeeTable set name=?, age=?, salary=?, birthDate=? where employeeID=?";
			PreparedStatement stmt = con.prepareStatement(q);
			stmt.setString(1, employee.getName());
//			stmt.setString(2, employee.getSkill());
//			String[] empSkill = employee.getSkills();
//			for (int i = 0; i < empSkill.length; i++) {
//				stmt.setString(2, empSkill[i].join(", ", empSkill));
//			}
			stmt.setInt(2, employee.getAge());
			stmt.setInt(3, employee.getSalary());
			stmt.setString(4, employee.getBirthDate());
			stmt.setInt(5, employee.getEmployeeID());
			int count = stmt.executeUpdate();
			if (count == 1) {
				isUpdated = true;
			}
		} catch (Exception e) {
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
	
	/*
	 * public int getDaoSkills(EmployeeSkills employeeSkill) { String q =
	 * "insert into EmployeeSkillsTable (EmployeeId, employeeSkills) values (?, ?)";
	 * int result = 0; try { Class.forName("com.mysql.cj.jdbc.Driver"); Connection
	 * con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB",
	 * "root", "root"); PreparedStatement stmt = con.prepareStatement(q);
	 * stmt.setString(1, employeeSkill.getSkill()); // String empSkill =
	 * employee1.getSkills(); // for (int i = 0; i < empSkill.length; i++) { //
	 * stmt.setString(2, empSkill[i].join(", ", empSkill)); // } result =
	 * stmt.executeUpdate();
	 * 
	 * stmt.close(); con.close();
	 * 
	 * } catch (Exception e) { System.out.println(e); }
	 * System.out.println("getDaoSkills working fine in dao"); return 0; }
	 */
}