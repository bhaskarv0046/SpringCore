package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ShoppingStore;

public class AfterThrowingTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Target sp obj ref
		ShoppingStore proxy=ctx.getBean("shopping", ShoppingStore.class);
		
		//invoke the b method
		try {
		String msg=proxy.shopping(new String[] {"shirt","trouser","watch"}, new Float[] {1500.0f,1999.9f,2500.0f});
		System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("____________________________________");
		try {
			String msg=proxy.shopping(new String[] {"shirt","trouser","shoe"} , null);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
