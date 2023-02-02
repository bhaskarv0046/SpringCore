package com.nt.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import com.nt.comps.Courier;
import com.nt.comps.Flipkart;

public class FlipkartFactory2 {
	private static Properties props;
	static {
		try {
			//create InputStream pointing to the properties file
			InputStream is=new FileInputStream("src/main/java/com/nt/commons/info.properties");
			props=new Properties();
			props.load(is);		
			System.out.println("FlipkartFactory2::         static method()");
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}//end of static
	
	public static Flipkart getInstance() {
		try {
		//get and load the dependent class name		
		String courierName=props.getProperty("courier.class.name");
		Class c = Class.forName(courierName);
		//get all the constructors of the loaded class
		Constructor cons[]=c.getDeclaredConstructors();
		//create object for Dependent class
		Courier courier=(Courier)cons[0].newInstance();
		//create Target class object
		Flipkart fpkt= new Flipkart();
		//assign dependent class obj to Target class object
		fpkt.setCourier(courier);
		//return target class object
		return fpkt;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
