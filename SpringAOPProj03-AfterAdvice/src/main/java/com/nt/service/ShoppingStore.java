package com.nt.service;

import org.springframework.stereotype.Service;

@Service("service")
public class ShoppingStore {
	public double shopping(String items[],Double prices[]) {
		//calculate bill
		double billAmt=0.0;
		for(double p:prices) {
			billAmt=billAmt+p;			
		}
	return billAmt;
	}
}
