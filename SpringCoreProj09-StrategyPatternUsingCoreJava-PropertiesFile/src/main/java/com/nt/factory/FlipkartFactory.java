package com.nt.factory;

import com.nt.comps.BlueDart;
import com.nt.comps.Courier;
import com.nt.comps.DHL;
import com.nt.comps.DTDC;
import com.nt.comps.Flipkart;

public class FlipkartFactory {
	//static factory method
	public static Flipkart getInstance(String courierType) {
		//create Dependent class object
		Courier courier=null;
		  if(courierType.equalsIgnoreCase("DHL"))
			  courier = new DHL();
		  else if(courierType.equalsIgnoreCase("dtdc"))
			  courier = new DTDC();
		  else if(courierType.equalsIgnoreCase("bluedart"))
			  courier = new BlueDart();
		  else
			  throw new IllegalArgumentException("Invalid courier type");
		  //create target class object
		  Flipkart fpkt = new Flipkart();
		  //assign dependent class object to target clas object
		  fpkt.setCourier(courier);
		  //return Target class object having Dependent class object
		  return fpkt;
			  
			  
		  
		
	}
	

}
