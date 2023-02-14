package com.nt.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get the targert class obj
		IEmployeeDAO dao=ctx.getBean("DAO",IEmployeeDAO.class);
		
		try {
			int count=dao.getEmployeesCountBySalaryRange(3000,4000);
			System.out.println("Total no of Employee in between salary range of 3000 to 4000 are :: "+count);
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("_________________________________________________________");
		try {
			List<Employee> list=dao.getEmpDetailsbyDesgs("SALESMAN","DEV","CLERK");
			System.out.println("Total no of Employee by Designations as SALESMAN,CLERK,MANAGER :: ");
			list.forEach(emp->{
				System.out.println(emp);
			});
			System.out.println("_________________________________________________________");
			list.forEach(emp->System.out.println(emp));
			System.out.println("_________________________________________________________");
			list.forEach(System.out::println);
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("_________________________________________________________");
		System.out.println("_________________________________________________________");
		try {
			Employee emp=new Employee(8032,"VaraPrasad","DEV",5600.0,40);
			int count=dao.insertEmployee(emp);
			if(count==0)
				System.out.println("Employee Not Registered ");
			else
				System.out.println("Employee Registered");
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}

	}

}
