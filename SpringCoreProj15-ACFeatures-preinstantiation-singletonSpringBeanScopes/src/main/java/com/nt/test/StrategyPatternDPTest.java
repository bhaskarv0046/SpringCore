package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.comps.Flipkart;

public class StrategyPatternDPTest {

	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		System.out.println("_______________________________________");
				
		//get target class object
		Flipkart fpkt = ctx.getBean("fpkt",Flipkart.class);
		//invoke the business method
		String resultMsg = fpkt.shopping(new String[] {"tshirt","trouser","Watch","shoes"},new float[] {1599.8f,1999.9f,5000.0f,2199.99f} );
		System.out.println(resultMsg);

	}

}
