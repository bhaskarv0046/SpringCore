package com.nt.comps;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fpkt")
public final class Flipkart {
	//has-A-Property
	@Autowired
	public Courier courier;
	
	public Flipkart() {
		System.out.println("Flipkart.Flipkart()");
	}
	
	public String shopping(String[] items,Float[] prices) {
		//calculate bill amount
		float billAmt=0;
		for(float p:prices)
			billAmt=billAmt+p;
		int oId=new Random().nextInt(10000);
		String deliverMsg=courier.deliver(oId);
		//final msg
		return Arrays.toString(items)+" items with prices as "+Arrays.toString(prices)+" having bill amount "+billAmt+" "+deliverMsg; 
		
	}

}
