package com.nt.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

public class JdbcTemplate_CallBackInterfaceTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get DAO impl class obj ref
		IEmployeeDAO dao=ctx.getBean("empDAO",IEmployeeDAO.class);
		
		try {
			//invoke the b method
			Employee emp=dao.getEmployeeByNo(7499);
			System.out.println(emp);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Record Not found (or) Problem in retrieving Record");
		}
		System.out.println("......................................................................");
		try {
			List<Employee> list=dao.getEmployeesByDesg("MANAGER","CLERK");
			/*
			 * list.forEach(emp->{ System.out.println(emp); });
			 */
			System.out.println("_____________________________________________");
			//list.forEach(emp->System.out.println(emp));
			System.out.println("_______________________________________________");
			list.forEach(System.out::println);
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("......................................................................................");
		
		ctx.close();
	}

}
