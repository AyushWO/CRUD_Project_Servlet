package com.company.entities;

import java.util.Arrays;

public class EmployeeSkills {
	private int employeeID;
	private String[] skills;
	private String skill;
	private int skillID;
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getSkillID() {
		return skillID;
	}
	public void setSkillID(int skillID) {
		this.skillID = skillID;
	}
	
	@Override
	public String toString() {
		return "EmployeeSkills [employeeID=" + employeeID + ", skills=" + Arrays.toString(skills) + ", skill=" + skill
				+ ", skillID=" + skillID + "]";
	}
	
	public EmployeeSkills(int employeeID, String[] skills, String skill, int skillID) {
		super();
		this.employeeID = employeeID;
		this.skills = skills;
		this.skill = skill;
		this.skillID = skillID;
	}
	
	public EmployeeSkills() {
		super();
		// TODO Auto-generated constructor stub
	}
}
