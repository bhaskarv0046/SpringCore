package com.nt.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileTest {

	public static void main(String[] args) {
		try {
		// TODO Auto-generated method stub
		InputStream is=new FileInputStream("src/main/java/com/nt/commons/info.properties");
		// Load data into Properties collection
		Properties props = new Properties();		
		props.load(is);
		//display data
		System.out.println("props object data :: "+props);
		System.out.println("person.name key value:: "+props.getProperty("per.name"));
		System.out.println("person.age key value:: "+props.getProperty("per.age"));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
