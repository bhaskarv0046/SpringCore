package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.comps.Flipkart;

public class StrategyPatternDPTest {

	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get target class object
		Flipkart fpkt = factory.getBean("fpkt",Flipkart.class);
		//invoke the business method
		String resultMsg = fpkt.shopping(new String[] {"tshirt","trouser","Watch","shoes"},new float[] {1599.8f,1999.9f,5000.0f,2199.99f} );
		System.out.println(resultMsg);

	}

}
