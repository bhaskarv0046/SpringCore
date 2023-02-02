package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.CitizenVotingEligibilityChecking;

public class BeanLifeCycleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get the target class ref
		CitizenVotingEligibilityChecking person=ctx.getBean("citizen",CitizenVotingEligibilityChecking.class);
		// use the b method
		String msg=person.checkVotingEligibility()	;
		System.out.println(msg);		
		
		//close the container
		ctx.close();
	}

}
