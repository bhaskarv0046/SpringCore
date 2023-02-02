package com.nt.test;

import com.nt.comps.Bike;
import com.nt.factory.BikeFactory;

public class FactoryPatternTest {

	public static void main(String[] args) {
		// get bike object
		Bike bike=BikeFactory.getBike("Honda");
		bike.ride();
		System.out.println("__________________________");
		
		Bike bike1=BikeFactory.getBike("BaJAJ");
		bike1.ride();
		System.out.println("_________________________");

	}

}
