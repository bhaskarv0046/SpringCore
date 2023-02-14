package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {
	public int getEmployeesCountBySalaryRange(double start,double end);
	public List<Employee> getEmpDetailsbyDesgs(String desg1,String desg2,String desg3);
	public int insertEmployee(Employee emp); 
}
