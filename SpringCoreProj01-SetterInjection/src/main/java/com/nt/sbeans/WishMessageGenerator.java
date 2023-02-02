//WishMessageGenerator
package com.nt.sbeans;

import java.util.Date;

public class WishMessageGenerator {
	//has a property
	private Date date;

	//Setter method for Setter Injection
	public void setDate(Date date) {
		System.out.println("WishMessageGenerator.setDate(-)");
		this.date = date;
	}
	
	//business method
	public String showWishMessage(String user) {
		//get current hour of the day
		int hour = date.getHours(); //gives 24hour format hour(0-23)
		//generate wish message
		if(hour<12)
			return "Good Morning :: "+user;
		else if(hour<16)
			return "Good Afternoon :: "+user;
		else if(hour<21)
			return "Good Evening :: "+user;
		else
			return "Good Night :: "+user;
		
	}
	
	
	

}
