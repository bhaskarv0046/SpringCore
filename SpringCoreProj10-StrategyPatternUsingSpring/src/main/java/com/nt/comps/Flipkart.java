package com.nt.comps;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart {	//final because to not allow modifications
	//has a property
	private Courier courier;
	
	public Flipkart() {
		System.out.println("Flipkart.Flipkart()");
	}

	//setter method for injection
	public void setCourier(Courier courier) {
		System.out.println("Flipkart.setCourier(-)");
		this.courier = courier;
	}
	//business method
	public String shopping(String items[],float prices[]) {
		//calculate bill amount
		float billAmt=0.0f;
		for(float p:prices)
			billAmt=billAmt+p;
		//generate random number as the order id
		int oid=new Random().nextInt(10000);
		// String type for deliver message
		String deliverMsg=courier.deliver(oid);
		//return final message
		return Arrays.toString(items)+"  with prices "+Arrays.toString(prices)+"  having bill amount:: "+billAmt+"  "+deliverMsg;		
	}//method
	
	

}
