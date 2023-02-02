package com.nt.test;

import com.nt.comps.Flipkart;
import com.nt.factory.FlipkartFactory;

public class StrategyPatternDPTest {

	public static void main(String[] args) {
		// use factory to get target class object
		Flipkart fpkt=FlipkartFactory.getInstance("dhl");
		//invoke the b method
		String resultMsg= fpkt.shopping(new String[] {"shirt","trouser","watch","shoes"}, new float[]{2000.5f,2520.0f,5500.9f,1599.9f});
		System.out.println(resultMsg);

	}

}
