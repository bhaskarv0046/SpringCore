//target class
package com.nt.sbeans;

import java.util.Date;

public class Employee {
	private int eno;
	private String ename;
	private Date dob;
	private double salary;
	private Department dept;
	
	public Employee() {
		System.out.println("Employee.Employee()::  0-param constructor");
	}
	
	//setter methods for setter injection
	public void setEno(int eno) {
		this.eno = eno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	//toString
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", dob=" + dob + ", salary=" + salary + ", dept=" + dept
				+ "]";
	}
	
	 
	
	
	
	
	
	
	

}
