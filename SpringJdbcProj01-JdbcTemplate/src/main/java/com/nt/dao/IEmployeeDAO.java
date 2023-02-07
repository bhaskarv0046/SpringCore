package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {
	//select queries
	public int getEmployeesCount();
	 public String getEmpNameByEmpId(int eno); 
	 public Map<String,Object> getEmployeeByNo(int no);
	 public List<Map<String,Object>> getEmpDetailsByDesg(String desg1,String desg2);
	 //non-select queries
	 public int registerEmployee(int eno,String ename,String desg,double salary);
	 public int addBonusToEmployeesBySalaryRange(double bounusAmt,double startSalary,double endSalary);
	 public int fireEmployeesByDesg(String desg);

}
