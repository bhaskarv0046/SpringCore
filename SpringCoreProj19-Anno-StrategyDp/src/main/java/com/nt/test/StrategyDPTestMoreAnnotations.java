package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.comps.Flipkart;

public class StrategyDPTestMoreAnnotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//load target class obj ref
		Flipkart fpkt=ctx.getBean("fpkt",Flipkart.class);
		//invoke the b method
		String resultMsg=fpkt.shopping(new String[] {"Shirt","Jeans","Watch","belt"} , new Float[] {1459.0f,1999.9f,7599.7f,450.5f});
		System.out.println(resultMsg);
		

	}

}
