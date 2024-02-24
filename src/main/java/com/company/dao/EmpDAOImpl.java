package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

			String[] empSkill = employee1.getSkills();
			for (int i = 0; i < empSkill.length; i++) {
				stmt.setString(2, empSkill[i].join(", ", empSkill));
			}

			result = stmt.executeUpdate();

			stmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		} finally {

		}
		System.out.println("It's done");
		return 0;
	}

	public ArrayList<Employee> readAllEmpDAO() {
		ArrayList<Employee> list = new ArrayList<Employee>();
		Employee employee = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			String q = "select * from EmployeeTable";
			PreparedStatement stmt = con.prepareStatement(q);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				employee = new Employee();
				employee.setName(rs.getString(1));
				String[] skills = employee.getSkills();
				for (int i = 0; i < skills.length; i++) {
					skills[i].split(", ", 2).toString();
				}
				employee.setAge(rs.getInt(3));
				employee.setSalary(rs.getInt(4));
				employee.setBirthDate(rs.getString(5));
			}
			list.add(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateEmpDAO() {

	}

	@Override
	public void deleteEmpDAO() {

	}

//	public static void main(String[] args) {
//		try {
//			
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
//			String q = "insert into EmployeeTable values(?,?,?,?,?,?)";
//			PreparedStatement stmt = con.prepareStatement(q);
//			stmt.setInt(1, empId);
//			stmt.setString(2, empName);
//			stmt.setString(3, empSkill);
//			stmt.setInt(4, empAge);
//			stmt.setInt(5, empSalary);
//			stmt.setString(6, empBirthDate);
//			stmt.execute();
//			stmt.close();
//			con.close();
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		System.out.println("It's done");
//	}

}
