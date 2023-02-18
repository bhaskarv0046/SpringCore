package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ResidentOperationsService;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get the spring bean cls obj ref
		ResidentOperationsService service=ctx.getBean("roService",ResidentOperationsService.class);
		//invoke the b method
		try{
			String msg=service.arrangeLunchForGuest("Ravikiran",8585859696l, 5);		
		    System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ctx.close();

	}

}
