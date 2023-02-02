package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.WishMessageGenerator;

public class AutowiringTest {

	public static void main(String[] args) {
		// create container
		//FileSystemXmlApplicationContext ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
				
		//get Target Spring bean class obj
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		
		//invoke the business method
		String result=generator.showWishMessage("ravi");
		System.out.println("Result::  "+result);
		
		ctx.close();
		

	}

}
