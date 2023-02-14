package com.nt.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get DAO impl class obj ref
		IEmployeeDAO dao=ctx.getBean("empDAO",IEmployeeDAO.class);
		
		try {
			//invoke the b method
			Employee emp=new Employee(8037,"OKumar","DEV",4500.8,40);
			int count=dao.insert(emp);
			if(count==0)
				System.out.println("Employee not registered");
			else
				System.out.println("Employee Registered");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		System.out.println("......................................................................");
		
		System.out.println("......................................................................................");
		
		ctx.close();
	}

}
