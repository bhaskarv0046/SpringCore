package com.nt.factory;

import java.lang.reflect.Constructor;

import com.nt.comps.Bike;

public class BikeFactory2 {
	public static <T extends Bike> T getBike(Class<T> clazz) throws Exception {
		//get all constructors of the class
		Constructor cons[]=clazz.getDeclaredConstructors();
		//create object
		return (T) cons[0].newInstance();
	}
	

}
