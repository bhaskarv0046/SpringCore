package com.nt.factory;

import com.nt.comps.Bajaj;
import com.nt.comps.Bike;
import com.nt.comps.Honda;
import com.nt.comps.Suzuki;

public class BikeFactory {
	//static factory method
	public static Bike getBike(String type) {
		Bike bike=null;
		if(type.equalsIgnoreCase("bajaj"))
			bike=new Bajaj();
		else if(type.equalsIgnoreCase("honda"))
			bike=new Honda();
		else if(type.equalsIgnoreCase("suzuki"))
			bike=new Suzuki();
		else 
			throw new IllegalArgumentException("invalid bike model...");
		return bike;
	}

}
