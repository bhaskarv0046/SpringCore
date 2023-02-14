package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.IEmployeeMgmtService;
 
public class SimpleJdbcCallTest {
	public static void main(String args[]){
		//create IOC container
	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	//get Sevice class object
	IEmployeeMgmtService service=ctx.getBean("empService",IEmployeeMgmtService.class);
	//b method
	try {
		String result=service.login("BHASKAR","bhaskar");
		System.out.println(result);
	}catch(DataAccessException dae) {
		dae.printStackTrace();
	}
	ctx.close();
	}
	
	
}
