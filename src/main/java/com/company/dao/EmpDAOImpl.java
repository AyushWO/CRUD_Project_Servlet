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
	    return list;
	}


	@Override
	public boolean updateEmpDAO(Employee employee) {
		boolean isUpdated = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			String q = "update EmployeeTable set name=?, skills=?, age=?, salary=?, birthDate=? where employeeID=?";
			PreparedStatement stmt = con.prepareStatement(q);
			stmt.setString(1, employee.getName());
			String[] empSkill = employee.getSkills();
			for (int i = 0; i < empSkill.length; i++) {
				stmt.setString(2, empSkill[i].join(", ", empSkill));
			}
			stmt.setInt(3, employee.getAge());
			stmt.setInt(4, employee.getSalary());
			stmt.setString(5, employee.getBirthDate());
			stmt.setInt(6, employee.getEmployeeID());
			int count = stmt.executeUpdate();
			if(count==1) {
				isUpdated = true;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
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
			System.out.println(stmt.executeUpdate());
			int count = stmt.executeUpdate();
			if(count==1) {
				isDeleted=true;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return isDeleted;
	}
}
