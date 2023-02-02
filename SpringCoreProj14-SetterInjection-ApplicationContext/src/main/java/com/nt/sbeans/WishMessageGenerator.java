package com.nt.sbeans;

import java.util.Date;

public class WishMessageGenerator {
	//private date property
	private Date date;
	
	public void setDate(Date date) {
		System.out.println("WishMessageGenerator.setDate()");
		this.date=date;		
	}
	
	public String showWishMessage(String user) {
		//get current hour of the day
		int hour=date.getHours();
		//generate message
		if(hour<12)
			return "Good Morning:: "+user;
		else if(hour<16)
			return "Good Afternoon::"+user;
		else if(hour<20)
			return "Good Evening  "+user;
		else
			return "Good Night "+user;		
	}

}
