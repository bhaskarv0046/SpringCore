package com.nt.test;

import com.nt.comps.Bajaj;
import com.nt.comps.Bike;
import com.nt.comps.Suzuki;
import com.nt.factory.BikeFactory2;

public class FactoryPatternTest2 {

	public static void main(String[] args) {
		// get bike object
		try{
			Bike bike=BikeFactory2.getBike(Suzuki.class);
			bike.ride();
			System.out.println("___________________________");
			
			Bike bike1 = BikeFactory2.getBike(Bajaj.class);
			bike1.ride();
			System.out.println("____________________________");
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
