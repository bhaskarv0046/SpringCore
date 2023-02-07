package com.nt.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dao.IEmployeeDAO;

public class JdbcTemplateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get target cls obj 
		IEmployeeDAO dao=ctx.getBean("empDAO",IEmployeeDAO.class);
		//invoke the b method
		try {
		System.out.println("Employee count is:: "+dao.getEmployeesCount());
		}catch(DataAccessException de) {
			de.printStackTrace();
		}
		System.out.println(".......................................................");
		
		try {
			System.out.println("Employee name is:: "+dao.getEmpNameByEmpId(7499));
			}catch(DataAccessException de) {
				de.printStackTrace();
			}
		try {
			System.out.println("Employee with ID 7499 info:: "+dao.getEmployeeByNo(7499));
			}catch(DataAccessException de) {
				de.printStackTrace();
			}
		System.out.println("...................................................................");
		
		try {
			//System.out.println("Total Employees with Designations as Manager & Salesmen :: "+dao.getEmpDetailsByDesg("MANAGER","SALESMAN"));
			List<Map<String,Object>> list=dao.getEmpDetailsByDesg("DEV","SALESMAN");
			list.forEach(record->{
				System.out.println(record);
			});
			
			}catch(DataAccessException de) {
				de.printStackTrace();
			}
		System.out.println("...................................................................");
		
		/*
		 * try { int count=dao.registerEmployee(8021,"VERMA","DEV", 4900.0);
		 * if(count==0) System.out.println("Employee Not Registered"); else
		 * System.out.println("New Employee details Registered");
		 * }catch(DataAccessException de) { de.printStackTrace(); }
		 */
		System.out.println("...................................................................");
		
		
		
		/*
		 * try { int updateCount=dao.addBonusToEmployeesBySalaryRange(99.0,2000,4000);
		 * System.out.println("Bonus added to "+updateCount+" No of Employees");
		 * }catch(DataAccessException de) { de.printStackTrace(); }
		 */
		 
		 
		System.out.println("...................................................................");
		
		try {
			int deleteCount = dao.fireEmployeesByDesg("DEV");
			System.out.println(deleteCount+" number of employees with designation DEV are deleted");
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		
		
		
		//close the container
		ctx.close();

	}

}
