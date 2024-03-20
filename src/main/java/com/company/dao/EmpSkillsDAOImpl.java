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

import com.company.empService.EmpServiceImpl;
import com.company.empService.EmpServiceInterface;
import com.company.entities.Employee;
import com.company.entities.EmployeeSkills;

public class EmpSkillsDAOImpl implements EmpSkillsDAOInterface {
	@Override
	public int insertEmpSkillsDAO(String skill, int id) {
		
		// String q = "insert into EmployeeTable values(?,?,?,?,?,?)";
		String q = "insert into EmployeeSkillsTable (employeeID ,skills) values (?, ?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			PreparedStatement stmt = con.prepareStatement(q);
			
			stmt.setInt(1, id);
			String[] empSkillArray = skill.split(", ");
			for (int i = 0; i < empSkillArray.length; i++) {
				stmt.setString(2, empSkillArray[i]);
				
				stmt.executeUpdate();
			}
			

			stmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Insert working fine in EmpSkillsdao");
		return 0;
	}

	@Override
	public ArrayList<EmployeeSkills> readAllEmpSkillsDAO() {
		ArrayList<EmployeeSkills> list = new ArrayList<EmployeeSkills>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		EmployeeSkills employeeSkills;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			String q = "select * from EmployeeSkillsTable";
			stmt = con.prepareStatement(q);
			rs = stmt.executeQuery();
			while (rs.next()) {
				employeeSkills = new EmployeeSkills();
				employeeSkills.setEmployeeID(rs.getInt("employeeID"));
				String skillsString = rs.getString("skills");
				String[] skillsArray = skillsString.split(", ");
				employeeSkills.setSkills(skillsArray);
//				employeeSkills.setEmployeeID(rs.getInt("SkillsID"));
				
				list.add(employeeSkills);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Add all data working fine in EmpSkillsdao");
		return list;
	}

	@Override
	public ArrayList<EmployeeSkills> getEmpSkillsById(int id) {   //here, I am getting, id=0 when code is moving from DB to service
		System.out.println("Message 82, EMpSkillsDAOImpl; id: "+id);
		ArrayList<EmployeeSkills> skillSet = new ArrayList<EmployeeSkills>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		EmployeeSkills employeeSkill1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
//			String q = "select * from EmployeeSkillsTable where skillID=?";
			String q = "select * from EmployeeSkillsTable where employeeID=?";
			stmt = con.prepareStatement(q);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				employeeSkill1 = new EmployeeSkills();
				String skillsString = rs.getString("skills");
				System.out.println("Message 99, EmpSkillsDAOImpl; skillsString: "+skillsString);
				String[] skillsArray = skillsString.split(", ");
				System.out.println("Message 101, EmpSkillsDAOImpl skillsArray-> "+skillsArray);
				employeeSkill1.setSkills(skillsArray);
				employeeSkill1.setEmployeeID(rs.getInt("employeeID"));
//				employee1.setSkillID(rs.getInt("skillID"));
				
				skillSet.add(employeeSkill1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("data by ID working fine in EmpSkillsdao");
		System.out.println("Message 111, EmpSkillsDAOImpl skillSet: -> "+skillSet);  
		return skillSet;
	}

	@Override
	public boolean updateEmpSkillsDAO(EmployeeSkills employeeSkills, String skills) {
		boolean isUpdated = false;
		try {
			System.out.println("Message 118, EmpskillsDAOImpl; skills: "+skills);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			String q = "update EmployeeSkillsTable set skills=? where skillID=?";
			PreparedStatement stmt = con.prepareStatement(q);
			System.out.println("Message 126, EmpSkillsDAOImpl");
//			
			String[] empSkillArray = skills.split(", ");
			for (int i = 0; i < empSkillArray.length; i++) {
				System.out.println("Message 129, EmpSkillsDAOImpl; splitedSkills: "+empSkillArray);   //you'll get the loop of skills like this : [Ljava.lang.String;@7a6e78df
				stmt.setString(1, empSkillArray[i]);
//				stmt.executeUpdate();
			}
			System.out.println("Message 134, EmpSkillsDAOImpl; splitedSkills: "+empSkillArray.toString());
//			stmt.setString(1, employeeSkills.getSkill());
			stmt.setInt(2, employeeSkills.getSkillID());
//			stmt.setString(1, skills);
//			stmt.setString(2, employee.getSkill());
//			String[] empSkill = employee.getSkills();
//			for (int i = 0; i < empSkill.length; i++) {
//				stmt.setString(1, empSkill[i].join(", ", empSkill));
//			}
			
			System.out.println("Message 144, EmpSkillsDAOImpl; skills: "+skills);
			int count = stmt.executeUpdate();
			System.out.println("Message 146, EmpSkillsDAOImpl -> count: "+count);  
			if (count == 1) {
				System.out.println("Message 148, EmpSkillsDAOImpl");
				isUpdated = true;
			}
		} catch (Exception e) {
			System.out.println("Message 152, EmpSkillsDAOImpl");
			e.printStackTrace();
		}
		System.out.println("update data working fine in EmpSkillsdao");
		System.out.println("Message 156, EmpSkillsDAOImpl -> isUpdated: "+isUpdated);
		return isUpdated;
	}

	@Override
	public boolean deleteEmpSkillsDAO(int id) {
		boolean isDeleted = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			String q = "delete from EmployeeSkillsTable where skillID=?";
			PreparedStatement stmt = con.prepareStatement(q);
			stmt.setInt(1, id);
			int count = stmt.executeUpdate();
			if (count == 1) {
				isDeleted = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("delete data working fine in EmpSkillsdao");
		return isDeleted;
	}
}


























/*
 * ALTER TABLE EmployeeSkillsTable DROP CONSTRAINT employeeID; ALTER TABLE
 * EmployeeSkillsTable DROP FOREIGN KEY employeeID;
 * 
 * ALTER TABLE EmployeeSkillsTable ADD CONSTRAINT `FOREIGN KEY` FOREIGN KEY
 * (`employeeID`) REFERENCES EmployeeTable (`employeeID`) ON DELETE CASCADE ON
 * UPDATE CASCADE;
 */
