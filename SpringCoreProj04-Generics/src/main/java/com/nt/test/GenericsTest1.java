package com.nt.test;

import java.lang.reflect.Constructor;

import com.nt.comps.Demo;
import com.nt.comps.Employee;
import com.nt.comps.Person;
import com.nt.comps.Student;

public class GenericsTest1 {
	
	public <T extends Person> T getPersonInfo(Class clazz) throws Exception {
		// get all constructors of the class
		Constructor cons[]=clazz.getDeclaredConstructors();
		//create and return object
		return (T)cons[0].newInstance();
	}

	public static void main(String[] args) {
		try {
			//create object
			GenericsTest1 gt1=new GenericsTest1();
			Employee emp=gt1.getPersonInfo(Employee.class);
			emp.m1(); emp.m2();
			System.out.println("_______________________");
			Student stud = gt1.getPersonInfo(Student.class);
			stud.m1(); stud.m3();
			System.out.println("_______________________");
			Person person=gt1.getPersonInfo(Person.class);
			person.m1();
								
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
