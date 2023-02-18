package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ShoppingStore;

public class AfterReturningAdviceTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Spring bean class obj ref
		ShoppingStore store=ctx.getBean("service",ShoppingStore.class);
		//invoke the b method
		try{
			Double billAmt=store.shopping(new String[] {"shirt","jeans","shoes"},new Double[] {1399.8,2999.9,2500.0});
			System.out.println("Bill Amount :: "+billAmt);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ctx.close();

	}

}
