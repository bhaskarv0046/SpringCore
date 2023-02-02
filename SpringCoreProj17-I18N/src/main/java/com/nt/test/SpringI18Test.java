package com.nt.test;

import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringI18Test {

	public static void main(String[] args) {
		// Create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//prepare locale object by supplying language and country
		Locale locale = new Locale(args[0],args[1]);
		//get messages from given Locale specific properties file
		String msg1=ctx.getMessage("welcome.msg",new Object[] {}, locale);//internally calls ctx.getBean("messageSource",ResourceBundleMessageSource.class)
		String msg2=ctx.getMessage("goodbye.msg",new Object[] {}, locale);
		System.out.println(msg1+"......................"+msg2);

	}

}
