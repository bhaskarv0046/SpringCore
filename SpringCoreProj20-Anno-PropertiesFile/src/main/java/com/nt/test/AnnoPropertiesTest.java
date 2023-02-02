package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.EmployeeInfo;

public class AnnoPropertiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get target class obj ref
		EmployeeInfo info=ctx.getBean("emp",EmployeeInfo.class);
		System.out.println("Employee Info data :::" +info);

	}

}
