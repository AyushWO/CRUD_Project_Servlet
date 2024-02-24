package com.company.entities;

import java.util.Arrays;

public class Employee {
	private int employeeID;
	private String name;
	private String[] skills;
	private int age;
	private int salary;
	private String birthDate;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Employee(int employeeID, String name, String[] skills, int age, int salary, String birthDate) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.skills = skills;
		this.age = age;
		this.salary = salary;
		this.birthDate = birthDate;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", name=" + name + ", skills=" + Arrays.toString(skills)
				+ ", age=" + age + ", salary=" + salary + ", birthDate=" + birthDate + "]";
	}
}
