package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.sbeans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		// Hold the name and location of spring bean cfg file
		FileSystemResource resource = new FileSystemResource("src/main/java/com/nt/cfgs/applicationContext.xml");
		//give the file resouce to the spring container
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		//get target spring bean class obj
		Object obj = factory.getBean("wmg");
		//get the target spring bean class obj
		WishMessageGenerator generator = (WishMessageGenerator)obj;
		String result = generator.showWishMessage("King");
		System.out.println("Result :: "+result);

	}

}
