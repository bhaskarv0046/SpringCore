package com.nt.sbeans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	//private date Has-a-property
	@Autowired
	private Date date;
	
	//b method
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator. :: 0-param Constructor");
	}
	
	public String showWishMessage(String user) {
		System.out.println("WishMessageGenerator.showWishMessage()  ::date::"+date.getYear() );
		int hour=date.getHours();
		if(hour<12)
			return "Good Morning  "+user;
		else if(hour<16)
			return "Good Afternoon  :"+user;
		else if(hour<20)
			return "Good Evening  :"+user;
		else
			return "Good Night :"+user;
	}

}
