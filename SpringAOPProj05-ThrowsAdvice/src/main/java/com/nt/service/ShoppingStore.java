package com.nt.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service("shopping")
public class ShoppingStore {
	
	public String shopping(String items[],Float prices[]) {
		System.out.println("ShoppingStore.shopping()");
		if(items==null || prices==null) {
			throw new IllegalArgumentException(" items or prices or both are not supplied");
		}
		double billAmt=0;
		for (double p:prices) {
			billAmt=billAmt+p;
		}
		return Arrays.toString(items)+"......."+Arrays.toString(prices)+".....BillAmount::"+billAmt;			
	}
}
