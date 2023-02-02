package com.nt.test;

import java.lang.reflect.Constructor;

public class NewInstanceMethodTest {

	public static void main(String[] args) {
		
		try{
			// Load the given class dynamically at runtime
			Class c=Class.forName(args[0]);
			//get all the constructors of given class dynamically
			Constructor cons[]=c.getDeclaredConstructors();
			//create objects for the loaded class
			Object obj1=cons[0].newInstance();	//creates the obj using 0-param construtor
			System.out.println(obj1);
			System.out.println("_________________________________");
			Object obj2=cons[1].newInstance(10,20);	//creates obj using 2-param constructor
			System.out.println(obj2);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
