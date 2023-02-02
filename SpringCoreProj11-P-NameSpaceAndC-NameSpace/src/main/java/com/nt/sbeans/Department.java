package com.nt.sbeans;

import java.util.Date;

public class Department {
	private int dno;
	private String dname;
	private int size;
	private Date startDate;
	//constructor for constructor injection
	public Department(int dno, String dname, int size, Date startDate) {
		System.out.println("Department.Department():: 4-param constructor");
		this.dno = dno;
		this.dname = dname;
		this.size = size;
		this.startDate = startDate;
	}
	//toString 
	@Override
	public String toString() {
		return "Department [dno=" + dno + ", dname=" + dname + ", size=" + size + ", startDate=" + startDate + "]";
	}
	
	
	
	
	

}
