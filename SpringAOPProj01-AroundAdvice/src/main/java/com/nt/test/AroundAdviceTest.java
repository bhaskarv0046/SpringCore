package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankOperationsService;

public class AroundAdviceTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class object
		BankOperationsService service=ctx.getBean("bankService",BankOperationsService.class);
		System.out.println(service.getClass()+"......................"+service.getClass().getSuperclass());
		//invoke the b methods
		try {
			System.out.println("Simple intrest amount:: "+service.calcSimpleIntrestAmount(10000.0, 2.0, 12.0));
			System.out.println("______________________________________________________");
			System.out.println("Compound interest amount:: "+service.calcCompoundIntrestAmount(10000.0,2.0,12.0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close the container
		ctx.close();

	}

}
