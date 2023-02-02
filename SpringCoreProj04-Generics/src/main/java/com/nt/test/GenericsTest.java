package com.nt.test;

import java.lang.reflect.Constructor;

import com.nt.comps.Demo;
import com.nt.comps.Employee;
import com.nt.comps.Student;

public class GenericsTest {
	
	public <T> T getPersonInfo(Class<T> clazz) throws Exception{
		//get all constructors of the class
		 Constructor cons[]=clazz.getDeclaredConstructors();
		 return (T)cons[0].newInstance();
	}

	public static void main(String[] args) {
		try {
		//create object
		GenericsTest gt=new GenericsTest();
		Employee emp=gt.getPersonInfo(Employee.class);
		emp.m1(); emp.m2();
		System.out.println("____________________________________");
		Student stud = gt.getPersonInfo(Student.class);
		stud.m1();
		stud.m3();
		System.out.println("________________________________________");
		Demo dt=gt.getPersonInfo(Demo.class);
		System.out.println(dt.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
