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
	public int insertEmpSkillsDAO(EmployeeSkills employeeSkills, String skill, String[] skills, int id) {
		System.out.println("Message 23, EmpSkillsDAOImpl; skill: "+skills);
		System.out.println("Message 24, EmpSkillsDAOImpl; id: "+id);
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
				
				list.add(employeeSkills);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Add all data working fine in EmpSkillsdao");
		return list;
	}

	@Override
	public HashSet<EmployeeSkills> getEmpSkillsById(int id, String[] skills) {   //here, I am getting, id=0 when code is moving from DB to service
		System.out.println("Message 81, EMpSkillsDAOImpl; id: "+id);
		HashSet<EmployeeSkills> skillSet = new HashSet<EmployeeSkills>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		EmployeeSkills employeeSkill1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			String q = "select * from EmployeeSkillsTable where employeeID=?";
			stmt = con.prepareStatement(q);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				employeeSkill1 = new EmployeeSkills();
				String skillsString = rs.getString("skills");
				String[] skillsArray = skillsString.split(", ");
				employeeSkill1.setSkills(skillsArray);
				employeeSkill1.setEmployeeID(rs.getInt("employeeID"));
				employeeSkill1.setSkillID(rs.getInt("skillID"));
				
				skillSet.add(employeeSkill1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("data by ID working fine in EmpSkillsdao");
		return skillSet;
	}

	@Override
	public boolean updateEmpSkillsDAO(EmployeeSkills employeeSkills, String[] skills, int id) {
		boolean isUpdated = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
			String q = "update EmployeeSkillsTable set skills=? where skillID=?";
			PreparedStatement stmt = con.prepareStatement(q);
			
			stmt.setString(1, employeeSkills.getSkill());
			stmt.setInt(2, employeeSkills.getSkillID());
			
			int count = stmt.executeUpdate();
			if (count == 1) {
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("update data working fine in EmpSkillsdao");
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
