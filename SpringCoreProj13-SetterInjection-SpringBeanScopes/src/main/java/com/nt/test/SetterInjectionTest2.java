package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.sbeans.WishMessageGenerator;

public class SetterInjectionTest2 {

	public static void main(String[] args) {
		// create IOC container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//create BeanDefinitionReader having container
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		// load spring bean configuration file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		//get target Spring bean class obj
		WishMessageGenerator generator = factory.getBean("wmg",WishMessageGenerator.class);
		WishMessageGenerator generator1 = factory.getBean("wmg",WishMessageGenerator.class);
		WishMessageGenerator generator2 = factory.getBean("wmg1",WishMessageGenerator.class);
		System.out.println(generator.hashCode()+"     "+generator1.hashCode());
		System.out.println("generator==generator1  ?? "+(generator==generator1) );
		System.out.println("generator1==generator2 ??  "+(generator1==generator2));
		//invoke the b method
		String result = generator.showWishMessage("Kevin Trapp");
		System.out.println("Result is:: "+result);
		

	}

}
